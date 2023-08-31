package io.thescenery.shopAssist.auth.service;

import io.thescenery.shopAssist.auth.dto.LoginRequestDto;
import io.thescenery.shopAssist.user.entity.User;

public interface IAuthService {

  public User loginWithPassword(LoginRequestDto loginRequestDto);
}
