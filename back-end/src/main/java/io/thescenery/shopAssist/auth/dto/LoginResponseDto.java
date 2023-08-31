package io.thescenery.shopAssist.auth.dto;

import lombok.*;

@Data
@Builder
public class LoginResponseDto {
    private String token;
}
