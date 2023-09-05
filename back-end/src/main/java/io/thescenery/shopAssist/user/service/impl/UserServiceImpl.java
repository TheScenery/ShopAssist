package io.thescenery.shopAssist.user.service.impl;

import io.thescenery.shopAssist.user.entity.User;
import io.thescenery.shopAssist.user.mapper.UserMapper;
import io.thescenery.shopAssist.user.service.IUserService;
import io.thescenery.shopAssist.user.vo.UserInfoVo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final UserMapper userMapper;


  public UserServiceImpl(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  private void exceptionWhenUserNull(User user) {
    if (user == null) {
      throw new RuntimeException("can not find user");
    }
  }

  private UserInfoVo userEntityToUserVo(User user) {
    exceptionWhenUserNull(user);
    return UserInfoVo.builder().id(user.getId()).name(user.getName()).avatar(user.getAvatar())
        .build();
  }

  @Override
  public UserInfoVo getUserById(long id) {
    return userEntityToUserVo(userMapper.getUserById(id));
  }

  @Override
  public User getUserByEmail(String email) {
    User user = userMapper.getUserByEmail(email);
    exceptionWhenUserNull(user);
    return user;
  }
}
