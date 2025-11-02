package org.project.springsecurityex.config;

import javax.servlet.DispatcherType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.DispatcherTypeRequestMatcher;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers(new DispatcherTypeRequestMatcher(DispatcherType.ERROR), new DispatcherTypeRequestMatcher(DispatcherType.FORWARD)).permitAll()
                .requestMatchers("/", "/login", "/register", "/resources/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/member/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated();

        http.formLogin();
        http.logout().logoutSuccessUrl("/");

        return http.build();
    }
}
