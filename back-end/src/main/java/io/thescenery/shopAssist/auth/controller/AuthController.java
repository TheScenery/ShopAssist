package io.thescenery.shopAssist.auth.controller;

import io.thescenery.shopAssist.auth.dto.LoginRequestDto;
import io.thescenery.shopAssist.auth.dto.LoginResponseDto;
import io.thescenery.shopAssist.auth.service.IAuthService;
import io.thescenery.shopAssist.auth.service.ITokenService;
import io.thescenery.shopAssist.shared.security.IPasswordService;
import io.thescenery.shopAssist.user.entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private final IPasswordService passwordService;
    private final IAuthService authService;

    private final ITokenService tokenService;

    public AuthController(IPasswordService passwordService, IAuthService authService, ITokenService tokenService) {
        this.passwordService = passwordService;
        this.authService = authService;
        this.tokenService = tokenService;
    }

    @GetMapping("/auth/encode-password")
    public String encodePassword(@RequestParam("password") String password) {
        return passwordService.encode(password);
    }

    @PostMapping("/auth/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginData) {
        User user = authService.loginWithPassword(loginData);
        if (user != null) {
           return new LoginResponseDto(tokenService.getToken(user.getId()));
        }
        return null;
    }
}
