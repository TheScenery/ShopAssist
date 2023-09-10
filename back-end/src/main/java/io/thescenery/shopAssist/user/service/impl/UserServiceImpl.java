package io.thescenery.shopAssist.user.service.impl;

import io.thescenery.shopAssist.shared.exception.NotFoundException;
import io.thescenery.shopAssist.user.entity.User;
import io.thescenery.shopAssist.user.mapper.UserMapper;
import io.thescenery.shopAssist.user.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final UserMapper userMapper;


  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  private User returnNonEmptyUser(User user) {
    if (user == null) {
      throw new NotFoundException("can not find user");
    }
    return user;
  }

  @Override
  public User getUserById(Long id) {
    return returnNonEmptyUser(userMapper.getUserById(id));
  }

  @Override
  public User getUserByEmail(String email) {
    return returnNonEmptyUser(userMapper.getUserByEmail(email));
  }
}
