package com.ssg.springsecurityex.dto;

import com.ssg.springsecurityex.domain.UserRole;
import com.ssg.springsecurityex.domain.UserStatus;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDetailDTO {

    private String managerId;
    private String managerName;
    private String managerPwd;
    private String managerCode;
    private String managerPhone;
    private String managerEmail;
    private String managerImgPath;

    private LocalDate managerHireDate;
    private LocalDate managerLastLogin;

    private UserRole managerRole;
    private UserStatus managerStatus;
}
