package org.project.springsecurityex.service;

import java.util.List;
import org.project.springsecurityex.dto.MemberDTO;

public interface MemberService {

    void joinMember(MemberDTO memberDTO);
    List<MemberDTO> memberList();
    MemberDTO get(String mid);
    void edit(MemberDTO member);
    void remove(String mid);
    void checkPassword(String rawPassword, String encodedPassword);
}
