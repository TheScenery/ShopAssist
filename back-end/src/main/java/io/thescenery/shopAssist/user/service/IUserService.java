package io.thescenery.shopAssist.user.service;

import io.thescenery.shopAssist.user.entity.User;
import io.thescenery.shopAssist.user.vo.UserInfoVo;

public interface IUserService {

  public UserInfoVo getUserById(long id);

  public User getUserByEmail(String email);
}
