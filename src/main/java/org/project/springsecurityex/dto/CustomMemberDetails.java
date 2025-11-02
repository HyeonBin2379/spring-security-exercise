package org.project.springsecurityex.dto;

import java.util.ArrayList;
import java.util.Collection;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.project.springsecurityex.domain.MemberVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Slf4j
@Data
public class CustomMemberDetails implements UserDetails {

    private MemberVO memberVO;

    public CustomMemberDetails(MemberVO memberVO) {
        this.memberVO = memberVO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        log.info(memberVO.getMRole());
        collection.add(new SimpleGrantedAuthority("ROLE_" + memberVO.getMRole()));
        return collection;
    }

    @Override
    public String getPassword() {
        log.info(memberVO.getMPassword());
        return memberVO.getMPassword();
    }

    @Override
    public String getUsername() {
        log.info(memberVO.getMID());
        return memberVO.getMID();
    }

    @Override
    public boolean isAccountNonExpired() {  // 계정 만료
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {   // 계정 잠금
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {  // 자격 증명 만료
        return true;
    }

    @Override
    public boolean isEnabled() {    // 로그인 가능한 계정인지
        return true;
    }
}
