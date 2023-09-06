package io.thescenery.shopAssist.workspace.mapper;

import io.thescenery.shopAssist.workspace.entity.Workspace;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkspaceMapper {
  Workspace getWorkspaceById(long id);

  ArrayList<Workspace> getWorkspacesByOwnerId(long ownerId);
}
