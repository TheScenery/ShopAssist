package io.thescenery.shopAssist.workspace.entity;

import lombok.Data;

@Data
public class Workspace {

  private long id;
  private String name;
  private long ownerId;
}
