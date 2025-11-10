package com.ssg.springsecurityex.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import com.ssg.springsecurityex.domain.MemberVO;
import com.ssg.springsecurityex.dto.CustomMemberDetails;
import com.ssg.springsecurityex.mapper.MemberMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberVO> userData = memberMapper.findById(username);
        return userData
                .map(CustomMemberDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
    }
}
