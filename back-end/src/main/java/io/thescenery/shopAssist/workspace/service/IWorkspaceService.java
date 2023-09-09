package io.thescenery.shopAssist.workspace.service;

import io.thescenery.shopAssist.workspace.dto.CreateWorkspaceDto;
import io.thescenery.shopAssist.workspace.entity.Workspace;

public interface IWorkspaceService {

  public Workspace getWorkspaceById(long id);

  public Workspace createWorkspace(CreateWorkspaceDto dto);
}
