package com.ssg.springsecurityex.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForgotPwdDTO {

    private String userId;
    private String userEmail;
}
