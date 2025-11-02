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

@Log4j2
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member/list")
    public void memberList(Model model) {
        List<MemberDTO> memberList = memberService.memberList();
        model.addAttribute("memberList", memberList);
    }

    @GetMapping("/register")
    public void registerGET() {

    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        memberService.joinMember(memberDTO);
        return "redirect:/member/list";
    }
}
