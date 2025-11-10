package com.ssg.springsecurityex.service;

import com.ssg.springsecurityex.dto.CompanyDetailDTO;
import com.ssg.springsecurityex.dto.DeliverymanDTO;
import com.ssg.springsecurityex.dto.ManagerDetailDTO;
import com.ssg.springsecurityex.dto.UserCriteria;
import com.ssg.springsecurityex.dto.UserDetailDTO;
import com.ssg.springsecurityex.dto.UserInfoUpdateDTO;
import com.ssg.springsecurityex.dto.UserPageDTO;
import com.ssg.springsecurityex.dto.UserStatUpdateDTO;

public interface MemberService {

    UserPageDTO<UserDetailDTO> getUserList(UserCriteria userCriteria);
    UserDetailDTO getUserById(String userId);

    ManagerDetailDTO getManagerById(String userId);
    CompanyDetailDTO getCompanyById(String userId);
    DeliverymanDTO getDeliverymenById(String userId);

    boolean registerUser(UserDetailDTO userDetailDTO);

    boolean modifyUser(UserInfoUpdateDTO userInfoUpdateDTO);           // 회원정보 변경
    boolean modifyUserStatus(UserStatUpdateDTO userStatUpdateDTO);     // 회원상태 변경(총관리자 전용)

    boolean deactivateUser(String currentId);          // 휴면회원 전환 신청
    boolean deactivateUserByAdmin(String targetId);    // 휴면회원 전환(총관리자 전용)
}
