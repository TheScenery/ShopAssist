package io.thescenery.shopAssist.auth.service.impl;

import io.thescenery.shopAssist.auth.dto.LoginRequestDto;
import io.thescenery.shopAssist.auth.service.IAuthService;
import io.thescenery.shopAssist.shared.security.IPasswordService;
import io.thescenery.shopAssist.user.entity.User;
import io.thescenery.shopAssist.user.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    @Resource
    private IUserService userService;

    @Resource
    private IPasswordService passwordService;
    @Override
    public User loginWithPassword(LoginRequestDto loginRequestDto) {
        User user = userService.getUserByEmail(loginRequestDto.getEmail());
        if (passwordService.match(loginRequestDto.getPassword(), user.getPassword())) {
            return user;
        }
        return null;
    }
}
