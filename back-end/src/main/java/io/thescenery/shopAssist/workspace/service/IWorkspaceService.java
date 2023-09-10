package io.thescenery.shopAssist.workspace.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.thescenery.shopAssist.workspace.entity.Workspace;

public interface IWorkspaceService extends IService<Workspace> {

  public Workspace getWorkspaceById(Long id);

  public Workspace createWorkspace(Workspace workspace);
}
