package io.thescenery.shopAssist.workspace.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Workspace {

  private long id;
  private String name;
  private long ownerId;
}
