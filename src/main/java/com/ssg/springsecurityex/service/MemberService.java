package com.ssg.springsecurityex.service;

import java.util.List;
import com.ssg.springsecurityex.dto.MemberDTO;

public interface MemberService {

    void joinMember(MemberDTO memberDTO);
    List<MemberDTO> memberList();
    MemberDTO get(String mid);
    void edit(MemberDTO member);
    void remove(String mid);
}
