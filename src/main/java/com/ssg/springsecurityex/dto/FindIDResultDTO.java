package com.ssg.springsecurityex.dto;

import com.ssg.springsecurityex.domain.UserRole;
import java.util.Arrays;
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
public class FindIDResultDTO {

    private UserRole userRole;
    private String userId;

    public void setUserRole(String userRole) {
        this.userRole = Arrays.stream(UserRole.values())
                .filter(role -> role.getRoleName().equals(userRole))
                .findAny()
                .get();
    }
}
