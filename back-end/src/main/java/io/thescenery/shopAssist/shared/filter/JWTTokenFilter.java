package io.thescenery.shopAssist.shared.filter;

import io.thescenery.shopAssist.shared.security.AuthFailedException;
import io.thescenery.shopAssist.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class JWTTokenFilter extends OncePerRequestFilter {

  private final String tokenPrefix = "Bearer ";

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    final String tokenHeader = request.getHeader("Authorization");
    if (tokenHeader == null) {
      throw new AuthFailedException("no auth header");
    }

    String token = tokenHeader.substring(tokenPrefix.length());

    if (JWTUtil.verifyToken(token)) {
      Authentication authentication =
          new TestingAuthenticationToken("username", "password", "ROLE_USER");
      SecurityContextHolder.getContext().setAuthentication(authentication);
      filterChain.doFilter(request, response);
    } else {
      throw new AuthFailedException("token verify failed");
    }
  }
}
