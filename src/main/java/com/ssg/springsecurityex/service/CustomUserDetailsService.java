package com.ssg.springsecurityex.service;

import com.ssg.springsecurityex.domain.UserVO;
import lombok.RequiredArgsConstructor;
import com.ssg.springsecurityex.dto.CustomUserDetails;
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
        UserVO userData = memberMapper.selectUserById(username);
        if (userData == null) {
            return null;
        }
        return new CustomUserDetails(userData);
    }
}
