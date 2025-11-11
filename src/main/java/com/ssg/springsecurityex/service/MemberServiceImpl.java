package com.ssg.springsecurityex.service;

import com.ssg.springsecurityex.domain.CompanyVO;
import com.ssg.springsecurityex.domain.DeliverymanVO;
import com.ssg.springsecurityex.domain.ManagerVO;
import com.ssg.springsecurityex.domain.UserVO;
import com.ssg.springsecurityex.dto.*;
import com.ssg.springsecurityex.mapper.MemberMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;

    @Override
    public UserPageDTO<UserDetailDTO> getUserList(UserCriteria userCriteria) {
        List<UserVO> userList = memberMapper.selectUsers(userCriteria);
        List<UserDetailDTO> userDetails = userList.stream()
                .map(userVO -> modelMapper.map(userVO, UserDetailDTO.class))
                .collect(Collectors.toList());
        int total = memberMapper.getCount(userCriteria);

        return UserPageDTO.<UserDetailDTO>builder()
                .cri(userCriteria)
                .dtoList(userDetails)
                .total(total)
                .build();
    }

    // 회원 리스트 조회 시, 승인대기/휴면상태/휴면대기인 회원의 정보를 관리자가 확인할 때 필요
    @Override
    public UserDetailDTO getUserById(String userId) {
        UserVO userVO = memberMapper.selectUserById(userId);
        UserDetailDTO userDetail = modelMapper.map(userVO, UserDetailDTO.class);
        return userDetail;
    }

    @Override
    public ManagerDetailDTO getManagerById(String userId) {
        ManagerVO managerVO = memberMapper.selectManagerById(userId);
        ManagerDetailDTO managerDetail = modelMapper.map(managerVO, ManagerDetailDTO.class);
        return managerDetail;
    }

    @Override
    public CompanyDetailDTO getCompanyById(String userId) {
        CompanyVO companyVO = memberMapper.selectCompanyById(userId);
        CompanyDetailDTO companyDetail = modelMapper.map(companyVO, CompanyDetailDTO.class);
        return companyDetail;
    }

    @Override
    public DeliverymanDTO getDeliverymenById(String userId) {
        DeliverymanVO deliverymanVO = memberMapper.selectDeliverymenById(userId);
        DeliverymanDTO deliverymanDTO = modelMapper.map(deliverymanVO, DeliverymanDTO.class);
        return deliverymanDTO;
    }

    @Override
    public boolean registerUser(UserDetailDTO userDetailDTO) {
        String userPwd = userDetailDTO.getUserPwd();
        userDetailDTO.setUserPwd(passwordEncoder.encode(userPwd));
        int affected = memberMapper.insertUser(userDetailDTO);
        return affected == 1;
    }

    @Override
    public boolean modifyUser(UserInfoUpdateDTO userInfoUpdateDTO) {
        int affected = memberMapper.updateUser(userInfoUpdateDTO);
        return affected == 1;
    }

    @Override
    public boolean modifyUserStatus(UserStatUpdateDTO userStatUpdateDTO) {
        int affected = memberMapper.updateUserStatus(userStatUpdateDTO);
        return affected == 1;
    }

    @Override
    public boolean deactivateUser(String currentId) {
        int affected = memberMapper.deleteUser(currentId);
        return affected == 1;
    }

    @Override
    public boolean deactivateUserByAdmin(String targetId) {
        int affected = memberMapper.deleteUserByAdmin(targetId);
        return affected == 1;
    }

    @Override
    public FindIDResultDTO getUserIdBy(FindIDDTO findIDDTO) {
        FindIDResultDTO foundID = memberMapper.findUserId(findIDDTO);
        return foundID;
    }

    @Override
    public ResetPwdDTO modifyOriginPwd(ForgotPwdDTO forgotPwdDTO) {
        return null;
    }
}
