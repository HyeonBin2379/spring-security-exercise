package com.ssg.springsecurityex.controller;

import com.ssg.springsecurityex.dto.UserDetailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.ssg.springsecurityex.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        log.info("GET login page... /login");
        return "redirect:/auth/login";
    }

    @GetMapping("/auth/login")
    public String loginGET() {
        log.info("GET login page... /auth/login");
        return "auth/login";
    }

    @GetMapping("/auth/register-select")
    public void selectRole(String role, Model model) {
        log.info("select register role ... /auth/register-select");
        model.addAttribute("userRole", role);
    }

    @PostMapping("/auth/register-select")
    public String registerSelect(@RequestParam("role") String role) {
        log.info("POST register...");
        return "redirect:/auth/register/"+role;
    }

    @GetMapping("/auth/register")
    public String registerGet() {
        log.info("redirect to /auth/register-select");
        return "redirect:/auth/register-select";
    }

    @PostMapping("/auth/register")
    public String registerPost(UserDetailDTO userDetailDTO) {
        log.info(userDetailDTO.toString());

        // 회원가입 실패 시 회원가입 페이지로 이동

        // 회원가입 성공 시 로그인 페이지로 이동
        memberService.registerUser(userDetailDTO);
        return "redirect:/auth/login";
    }

    @GetMapping("/auth/register/{role}")
    public String registerGET(@PathVariable("role") String role, Model model) {
        log.info("GET member register ...");
        model.addAttribute("userRole", role);
        return "auth/register";
    }

    @GetMapping("/logout")
    public String logout() throws Exception {
        return "redirect:/auth/logout";
    }
}
