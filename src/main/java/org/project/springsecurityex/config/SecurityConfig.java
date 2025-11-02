package org.project.springsecurityex.config;

import javax.servlet.DispatcherType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.DispatcherTypeRequestMatcher;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers("/resources/**");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 인가 작업: 로그인한 회원의 권한에 따라 접근 가능한 경로의 범위를 설정하는 것
        http.authorizeHttpRequests()
                .requestMatchers(new DispatcherTypeRequestMatcher(DispatcherType.ERROR), new DispatcherTypeRequestMatcher(DispatcherType.FORWARD)).permitAll()
                .requestMatchers("/").permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/member/register-select"), AntPathRequestMatcher.antMatcher("/member/register")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/login"), AntPathRequestMatcher.antMatcher("/loginProcess")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/member/**")).hasAnyRole("COMPANY")
                .requestMatchers("/admin/**").hasAnyRole("ADMIN", "MANAGER")
                .anyRequest().permitAll();  // ControllerAdvice를 통해 404 에러 처리 -> 유효하지 않은 URL 요청 시 커스텀 에러 페이지 출력

        // 로그인/로그아웃 처리
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("mID")
                .passwordParameter("mPassword")
                .loginProcessingUrl("/loginProcess")
                .defaultSuccessUrl("/", true)
                .failureUrl("/error/custom401")
                .permitAll();

        http.logout().logoutSuccessUrl("/");

        // 사이트 위변조 방지 설정
        http.csrf().disable();

        return http.build();
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        hierarchy.setHierarchy("ROLE_ADMIN > ROLE_MANAGER\n" + "ROLE_MANAGER > ROLE_COMPANY");
        return hierarchy;
    }
}
