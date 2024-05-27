package org.ohara.maVraiDep.data.security.controllers.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationRequestDto {
    private String username;
    private String password;
}
