package io.thescenery.shopAssist.user.controller;

import io.thescenery.shopAssist.user.service.IUserService;
import io.thescenery.shopAssist.user.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

  private final IUserService userService;

  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user/{id}")
  UserInfoVo getUserById(@PathVariable int id) {
    return userService.getUserById(id);
  }

  @GetMapping("/currentUser")
  UserInfoVo getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    return userService.getUserById((Long) authentication.getPrincipal());
  }
}
