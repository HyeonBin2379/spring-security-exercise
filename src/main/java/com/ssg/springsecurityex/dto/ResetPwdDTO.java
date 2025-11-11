package com.ssg.springsecurityex.dto;

import com.ssg.springsecurityex.domain.UserRole;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResetPwdDTO {

    private String userId;
    private String userPwd;
    private UserRole userRole;
}
