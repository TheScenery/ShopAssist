package io.thescenery.shopAssist.workspace.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.thescenery.shopAssist.workspace.entity.Workspace;
import java.util.ArrayList;

public interface IWorkspaceService extends IService<Workspace> {

  public Workspace getWorkspaceById(Long id);

  public Workspace createWorkspace(Workspace workspace);

  public ArrayList<Workspace> getWorkspacesByOwnerId(Long ownerId);
}
