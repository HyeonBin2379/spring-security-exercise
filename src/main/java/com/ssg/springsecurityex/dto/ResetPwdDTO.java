package com.ssg.springsecurityex.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResetPwdDTO {

    private String targetId;
    private String newPwd;
}
