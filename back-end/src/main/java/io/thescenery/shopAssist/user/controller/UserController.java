package io.thescenery.shopAssist.user.controller;

import io.thescenery.shopAssist.user.service.IUserService;
import io.thescenery.shopAssist.user.vo.UserInfoVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

  private final IUserService userService;

  public UserController(IUserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user/{id}")
  UserInfoVo getUserById(@PathVariable int id) {
    return userService.getUserById(id);
  }
}
