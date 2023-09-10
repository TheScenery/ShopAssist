package io.thescenery.shopAssist.user.controller;

import io.thescenery.shopAssist.user.dto.UserResponseDto;
import io.thescenery.shopAssist.user.entity.User;
import io.thescenery.shopAssist.user.service.IUserService;
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

  private UserResponseDto userToUserResponseDto(User user) {
    return UserResponseDto.builder().id(user.getId()).name(user.getName()).avatar(user.getAvatar())
        .build();
  }

  @GetMapping("/user/{id}")
  UserResponseDto getUserById(@PathVariable Long id) {
    return userToUserResponseDto(userService.getUserById(id));
  }

  @GetMapping("/currentUser")
  UserResponseDto getCurrentUser() {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    return userToUserResponseDto(userService.getUserById((Long) authentication.getPrincipal()));
  }
}
