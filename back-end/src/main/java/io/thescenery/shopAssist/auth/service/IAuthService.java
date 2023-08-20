package io.thescenery.shopAssist.auth.service;

import io.thescenery.shopAssist.auth.dto.LoginRequestDto;

public interface IAuthService {
    public boolean loginWithPassword(LoginRequestDto loginRequestDto);
}
