package io.thescenery.shopAssist.user.service;

import io.thescenery.shopAssist.user.entity.User;

public interface IUserService {

  public User getUserById(Long id);

  public User getUserByEmail(String email);
}
