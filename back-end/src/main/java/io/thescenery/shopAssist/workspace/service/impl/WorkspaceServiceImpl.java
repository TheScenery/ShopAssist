package io.thescenery.shopAssist.workspace.service.impl;

import io.thescenery.shopAssist.workspace.entity.Workspace;
import io.thescenery.shopAssist.workspace.mapper.WorkspaceMapper;
import io.thescenery.shopAssist.workspace.service.IWorkspaceService;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceServiceImpl implements IWorkspaceService {

  private final WorkspaceMapper workspaceMapper;

  public WorkspaceServiceImpl(WorkspaceMapper workspaceMapper) {
    this.workspaceMapper = workspaceMapper;
  }

  @Override
  public Workspace getWorkspaceById(long id) {
    Workspace workspace = workspaceMapper.getWorkspaceById(id);
    if (workspace == null) {
      throw new RuntimeException("can not find workspace: " + id);
    }
    return workspace;
  }
}