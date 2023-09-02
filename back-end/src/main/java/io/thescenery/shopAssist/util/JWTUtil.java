package io.thescenery.shopAssist.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ConfigurationProperties(prefix = "jwt")
public class JWTUtil {

  private static String secretKey;

  public void setSecretKey(String secretKey) {
    JWTUtil.secretKey = secretKey;
  }

  private static Algorithm getAlgorithm() {
    return Algorithm.HMAC256(secretKey);
  }

  public static String generateToken(int userId) {
    return JWT.create()
        .withClaim("userId", userId)
        .withClaim("timeStamp", System.currentTimeMillis())
        .sign(getAlgorithm());
  }

  public static boolean verifyToken(String token) {
    try {
      JWT.require(getAlgorithm()).build().verify(token);
    } catch (JWTVerificationException e) {
      log.error(e.getMessage());
      return false;
    }
    return true;
  }
}
