package io.thescenery.shopAssist.dao;

import io.thescenery.shopAssist.mapper.UserMapper;
import io.thescenery.shopAssist.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements UserMapper {
    private final UserMapper userMapper;

    public UserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
