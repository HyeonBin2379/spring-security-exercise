package org.project.springsecurityex.mapper;

import java.util.List;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.project.springsecurityex.domain.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTests {

    @Autowired(required = false)
    private MemberMapper memberMapper;

    @Test
    public void testSelectAll() {
        List<MemberVO> list = memberMapper.findAll();
        list.forEach(log::info);
    }

    @Test
    public void testFindById() {
        String mid = "member00";
        Optional<MemberVO> optionalMemberVO = memberMapper.findById(mid);
        Assertions.assertTrue(optionalMemberVO.isPresent());
    }

    @Test
    public void testFindById2() {
        String mid = "member99";
        Optional<MemberVO> optionalMemberVO = memberMapper.findById(mid);
        Assertions.assertFalse(optionalMemberVO.isPresent());
    }

    @Test
    public void testInsert() {
        MemberVO vo = MemberVO.builder()
                .mID("member04")
                .mPassword("3333")
                .mName("tester")
                .build();
        memberMapper.insert(vo);
    }

    @Test
    public void testUpdate() {
        String mid = "member00";
        MemberVO memberVO = MemberVO.builder()
                .mID(mid)
                .mPassword("1234")
                .mName("tester")
                .build();
        Assertions.assertTrue(memberMapper.update(memberVO));
    }

    @Test
    public void testDelete() {
        String mid = "member04";
        Assertions.assertTrue(memberMapper.delete(mid));
    }

    @Test
    public void testExistID() {
        String mID = "member00";
        Assertions.assertTrue(memberMapper.existByID(mID));
    }
}
