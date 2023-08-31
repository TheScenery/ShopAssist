package io.thescenery.shopAssist.auth.service;

public interface ITokenService {
    public String getToken(int userId);
    public boolean verifyToken(String token);
}
