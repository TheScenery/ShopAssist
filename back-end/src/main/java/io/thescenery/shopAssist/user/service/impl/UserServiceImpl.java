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

    @Override
    public UserInfoVo getUserById(int id) {
        UserInfoVo userInfoVo = new UserInfoVo();
        User user = userMapper.getUserById(id);
        userInfoVo.setId(user.getId());
        userInfoVo.setName(user.getName());
        return userInfoVo;
    }
}
