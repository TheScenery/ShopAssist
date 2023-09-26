package io.thescenery.shopAssist.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {

  public static Long getCurrentUserId() {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    return (Long) authentication.getPrincipal();
  }
}
