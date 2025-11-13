package com.ssg.springsecurityex.dto;

import com.ssg.springsecurityex.domain.UserRole;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FindIDResultDTO {

    private String userId;
    private UserRole userRole;

    public void setUserRole(String userRole) {
        this.userRole = Arrays.stream(UserRole.values())
                .filter(role -> role.getRoleName().equals(userRole))
                .findAny()
                .get();
    }
}
