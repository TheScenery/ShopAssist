package io.thescenery.shopAssist.user.entity;

import java.util.Date;
import lombok.Data;

@Data
public class User {

  private Long id;
  private String name;
  private String password;
  private String avatar;
  private Date createTime;
  private Date updateTime;
}
