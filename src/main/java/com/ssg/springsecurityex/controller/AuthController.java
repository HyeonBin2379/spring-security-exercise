package com.ssg.springsecurityex.controller;

import com.ssg.springsecurityex.dto.FindIDDTO;
import com.ssg.springsecurityex.dto.FindIDResultDTO;
import com.ssg.springsecurityex.dto.UserDetailDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.ssg.springsecurityex.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    // 로그인/로그아웃 경로 설정
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

    @GetMapping("/logout")
    public String logout() throws Exception {
        return "redirect:/auth/logout";
    }

    // 회원가입 경로 설정
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

    @GetMapping("/auth/register/{role}")
    public String registerGET(@PathVariable("role") String role, Model model) {
        log.info("GET member register ...");
        model.addAttribute("userRole", role);
        return "auth/register";
    }

    @PostMapping("/auth/register")
    public String registerPost(UserDetailDTO userDetailDTO) {
        log.info(userDetailDTO.toString());

        // 회원가입 실패 시 회원가입 페이지로 이동

        // 회원가입 완료 시 로그인 페이지로 이동
        memberService.registerUser(userDetailDTO);
        return "redirect:/auth/login";
    }

    @GetMapping("/auth/forgot-id")
    public String forgotId() {
        log.info("GET /auth/forgot-id...");
        return "auth/forgot-id";
    }

    @PostMapping("/auth/forgot-id")
    public String forgotId(String userRole) {
        log.info("POST /auth/forgot-id...");
        return "redirect:/auth/forgot-id/" + userRole;
    }

    @GetMapping("/auth/forgot-id/{role}")
    public String forgotIdSelectRole(@PathVariable("role") String targetRole, Model model) {
        log.info("GET /auth/forgot-id/" + targetRole);

        model.addAttribute("targetRole", targetRole);
        return "auth/forgot-id-form";
    }

    @PostMapping("/auth/forgot-id/result")
    public String searchIdByUserInfo(FindIDDTO findIDDTO, RedirectAttributes redirectAttributes) {
        log.info("POST /auth/forgot-id/result...");
        log.info("findInput: " + findIDDTO.getUserCode());
        FindIDResultDTO foundDTO = memberService.getUserIdBy(findIDDTO);
        log.info("found userId: " + foundDTO.getUserId());

        redirectAttributes.addFlashAttribute("foundDTO", foundDTO);
        return "redirect:/auth/forgot-id/result";
    }

    @GetMapping("/auth/forgot-id/result")
    public String foundIdResult(@ModelAttribute("foundDTO") FindIDResultDTO foundDTO, Model model) {
        log.info("GET /auth/forgot-id/result...");

        return "auth/search-id-result";
    }
}
