package io.thescenery.shopAssist.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
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

  public static DecodedJWT validateToken(String token) {
    return JWT.require(getAlgorithm()).build().verify(token);
  }

  public static boolean verifyToken(String token) {
    try {
      validateToken(token);
    } catch (JWTVerificationException e) {
      log.error(e.getMessage());
      return false;
    }
    return true;
  }

  public static int getUserIdFromToken(String token) {
    DecodedJWT decodedJWT = validateToken(token);
    Claim userIdClaim = decodedJWT.getClaim("userId");
    return userIdClaim.asInt();
  }
}
