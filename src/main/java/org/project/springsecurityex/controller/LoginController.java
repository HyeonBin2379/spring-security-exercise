package org.project.springsecurityex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.springsecurityex.dto.MemberDTO;
import org.project.springsecurityex.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public void loginGET() {
        log.info("GET login page...");
    }

//    @PostMapping("/loginProcess")
//    public String loginProcess(RedirectAttributes redirectAttributes) {
//        return "redirect:/";
//    }

    @GetMapping("/register-select")
    public void selectRole(String mRole, Model model) {
        log.info("select register role ...");
        model.addAttribute("mRole", mRole);
    }

    @GetMapping("/register")
    public void registerGET(String mRole, Model model) {
        log.info("GET member register ...");
        model.addAttribute("mRole", mRole);
    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        log.info(memberDTO.toString());

        // 회원가입 실패 시 회원가입 페이지로 이동

        // 회원가입 성공 시 로그인 페이지로 이동
        memberService.joinMember(memberDTO);
        return "redirect:/auth/login";
    }
}
