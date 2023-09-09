package io.thescenery.shopAssist.workspace.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateWorkspaceDto {

  private long ownerId;
  private String name;
}
