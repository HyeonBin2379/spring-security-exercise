package com.ssg.springsecurityex.dto;

import com.ssg.springsecurityex.domain.UserStatus;
import com.ssg.springsecurityex.domain.VehicleModel;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliverymanDTO {

    private String delivId;
    private String delivName;
    private String delivPwd;
    private String delivPhone;
    private String delivEmail;
    private String delivCode;
    private String delivImgPath;
    private String delivVhcId;

    private VehicleModel delivVhcModel; // ENUM 사용
    private UserStatus delivStatus;     // 배송기사 회원상태 확인 가능
    private LocalDate delivLastLogin;
}
