package io.thescenery.shopAssist.auth.controller;

import io.thescenery.shopAssist.auth.dto.LoginRequestDto;
import io.thescenery.shopAssist.auth.dto.LoginResponseDto;
import io.thescenery.shopAssist.auth.service.IAuthService;
import io.thescenery.shopAssist.shared.security.IPasswordService;
import io.thescenery.shopAssist.user.entity.User;
import io.thescenery.shopAssist.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api")
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
  public LoginResponseDto login(@RequestBody LoginRequestDto loginData) {
    User user = authService.loginWithPassword(loginData);
    if (user != null) {
      log.info("User login, userID: {}", user.getId());
      return LoginResponseDto.builder().token(JWTUtil.generateToken(user.getId())).build();
    }
    return null;
  }
}
