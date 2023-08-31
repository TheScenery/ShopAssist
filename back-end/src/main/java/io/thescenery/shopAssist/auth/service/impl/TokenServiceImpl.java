package io.thescenery.shopAssist.auth.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import io.thescenery.shopAssist.auth.service.ITokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements ITokenService {

  @Value("${token.secretKey}")
  private String secretKey;

  @Override
  public String getToken(int userId) {
    return JWT.create()
        .withClaim("userId", userId)
        .withClaim("timeStamp", System.currentTimeMillis())
        .sign(Algorithm.HMAC256(secretKey));
  }

  @Override
  public boolean verifyToken(String token) {
    try {
      JWT.require(Algorithm.HMAC256(secretKey)).build().verify(token);
    } catch (JWTVerificationException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }
}
