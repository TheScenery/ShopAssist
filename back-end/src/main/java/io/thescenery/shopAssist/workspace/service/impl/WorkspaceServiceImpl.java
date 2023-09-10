package io.thescenery.shopAssist.workspace.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.thescenery.shopAssist.shared.exception.NotFoundException;
import io.thescenery.shopAssist.workspace.entity.Workspace;
import io.thescenery.shopAssist.workspace.mapper.WorkspaceMapper;
import io.thescenery.shopAssist.workspace.service.IWorkspaceService;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceServiceImpl extends ServiceImpl<WorkspaceMapper, Workspace> implements
    IWorkspaceService {

  private final WorkspaceMapper workspaceMapper;

  public WorkspaceServiceImpl(WorkspaceMapper workspaceMapper) {
    this.workspaceMapper = workspaceMapper;
  }

  @Override
  public Workspace getWorkspaceById(Long id) {
    Workspace workspace = workspaceMapper.getWorkspaceById(id);
    if (workspace == null) {
      throw new NotFoundException("can not find workspace: " + id);
    }
    return workspace;
  }

  @Override
  public Workspace createWorkspace(Workspace workspace) {
    int result = workspaceMapper.insert(workspace);
    if (result != 0) {
      return workspace;
    }
    return null;
  }
}
