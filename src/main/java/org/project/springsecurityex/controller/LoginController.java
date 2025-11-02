package org.project.springsecurityex.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.springsecurityex.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public void loginGET(String error, Model model) {
        log.info("login page....");
        memberService.checkPassword("1111", "$2a$10$Qgm1Q4qYT5Id83dmP2erLOJCpupASfnuClVQZmPu4WkJQUPAbN1va");
        model.addAttribute("error", error);
    }
}
