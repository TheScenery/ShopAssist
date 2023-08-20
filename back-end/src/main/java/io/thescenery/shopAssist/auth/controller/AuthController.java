package io.thescenery.shopAssist.auth.controller;

import io.thescenery.shopAssist.auth.dto.LoginRequestDto;
import io.thescenery.shopAssist.auth.service.IAuthService;
import io.thescenery.shopAssist.shared.security.IPasswordService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private final IPasswordService passwordService;
    private final IAuthService authService;

    public AuthController(IPasswordService passwordService, IAuthService authService) {
        this.passwordService = passwordService;
        this.authService = authService;
    }

    @GetMapping("/auth/encode-password")
    public String encodePassword(@RequestParam("password") String password) {
        return passwordService.encode(password);
    }

    @PostMapping("/auth/login")
    public long login(@RequestBody LoginRequestDto loginData) {
        if (authService.loginWithPassword(loginData)) {
            return 0;
        }
        return -1;
    }
}
