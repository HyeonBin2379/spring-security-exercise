package org.project.springsecurityex.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.project.springsecurityex.domain.MemberVO;
import org.project.springsecurityex.dto.MemberDTO;
import org.project.springsecurityex.mapper.MemberMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@ToString
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void joinMember(MemberDTO memberDTO) {
        // 아이디 중복 검사
        if (memberMapper.existByID(memberDTO.getMID())) {
            log.error("중복된 아이디입니다.");
            return;
        }
        // 비밀번호 암호화 수행
        String encodedPwd = passwordEncoder.encode(memberDTO.getMPassword());
        memberDTO.setMPassword(encodedPwd);

        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberMapper.insert(memberVO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberDTO> memberList() {
        List<MemberVO> memberVOList = memberMapper.findAll();
        return memberVOList.stream()
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MemberDTO get(String mid) {
        Optional<MemberVO> selected = memberMapper.findById(mid);
        return selected
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("검색 실패"));
    }

    @Override
    @Transactional
    public void edit(MemberDTO member) {
        Optional<MemberVO> foundMember = memberMapper.findById(member.getMID());
        if (!foundMember.isPresent()) {
            throw new IllegalArgumentException();
        }
        MemberVO updated = foundMember.get();
        modelMapper.map(member, updated);
        memberMapper.update(updated);
    }

    @Override
    @Transactional
    public void remove(String mid) {
        memberMapper.delete(mid);
    }

    // [임시 테스트용 메서드 추가]
    public void checkPassword(String rawPassword, String encodedPassword) {
        boolean matches = passwordEncoder.matches(rawPassword, encodedPassword);
        log.info("========== PASSWORD TEST ==========");
        log.info("Raw: {}", rawPassword);
        log.info("Encoded: {}", encodedPassword);
        log.info("Result: {}", matches);
        log.info("===================================");
    }
}
