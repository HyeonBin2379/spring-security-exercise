package org.project.springsecurityex;

import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.project.springsecurityex.dto.MemberDTO;
import org.project.springsecurityex.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void testJoinMember() throws Exception {
        MemberDTO dto = MemberDTO.builder()
                .mid("member05")
                .mpw("4444")
                .mname("tester")
                .build();
        memberService.joinMember(dto);
    }

    @Test
    public void testMemberList() throws Exception {
        List<MemberDTO> list = memberService.memberList();
        list.forEach(log::info);
    }

    @Test
    public void testGet()  throws Exception {
        MemberDTO memberDTO = memberService.get("member00");
        log.info(memberDTO);
    }

    @Test
    public void testEdit() throws Exception {
        MemberDTO memberDTO = MemberDTO.builder()
                .mid("member05")
                .mpw("123456")
                .mname("updatedTester")
                .build();
        memberService.edit(memberDTO);
    }

    @Test
    public void testRemove() throws Exception {
        String mid = "member04";
        memberService.remove(mid);
    }
}
