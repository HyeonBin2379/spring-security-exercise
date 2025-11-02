package org.project.springsecurityex.mapper;

import java.util.List;
import java.util.Optional;
import org.project.springsecurityex.domain.MemberVO;

public interface MemberMapper {

    void insert(MemberVO vo);
    List<MemberVO> findAll();
    Optional<MemberVO> findById(String mid);
    boolean update(MemberVO vo);
    boolean delete(String mid);

    boolean existByID(String mID);
}
