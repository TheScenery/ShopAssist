package io.thescenery.shopAssist.auth.dto;

import lombok.*;

@Data
@Builder
public class LoginRequestDto {
    private String email;
    private String password;
}
