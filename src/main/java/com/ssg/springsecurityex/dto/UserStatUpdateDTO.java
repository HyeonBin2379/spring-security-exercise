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

/**
 * 회원정보에서 회원상태 변경 시 사용되는 DTO입니다.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStatUpdateDTO {

    private String userId;

    private UserRole userRole;

    private UserStatus userStatus;

    private LocalDate userJoinDate;
}
