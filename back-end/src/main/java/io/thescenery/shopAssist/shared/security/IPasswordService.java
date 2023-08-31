package io.thescenery.shopAssist.shared.security;

public interface IPasswordService {

  public String encode(CharSequence rawPassword);

  public boolean match(CharSequence rawPassword, String encodedPassword);
}
