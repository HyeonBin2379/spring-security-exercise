package com.ssg.springsecurityex.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import com.ssg.springsecurityex.dto.MemberDTO;
import com.ssg.springsecurityex.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public void memberList(Model model) {
        List<MemberDTO> memberList = memberService.memberList();
        model.addAttribute("memberList", memberList);
    }
}
