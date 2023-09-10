package io.thescenery.shopAssist.user.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoVo {

  private Long id;
  private String name;
  private String avatar;
}
