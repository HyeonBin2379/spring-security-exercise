package com.ssg.springsecurityex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindIDDTO {

    private String targetRole;
    private String userCode;
    private String userName;
    private String userEmail;
}
