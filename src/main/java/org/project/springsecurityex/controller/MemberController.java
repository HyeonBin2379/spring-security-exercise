package org.project.springsecurityex.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.project.springsecurityex.dto.MemberDTO;
import org.project.springsecurityex.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/register")
    public void registerGET() {
        log.info("GET member register ...");
    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        log.info(memberDTO);

        // 회원가입 실패 시 회원가입 페이지로 이동

        // 회원가입 성공 시 로그인 페이지로 이동
        memberService.joinMember(memberDTO);
        return "redirect:/login";
    }
}
