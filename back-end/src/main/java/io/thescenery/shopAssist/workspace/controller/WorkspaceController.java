package io.thescenery.shopAssist.workspace.controller;

import io.thescenery.shopAssist.workspace.entity.Workspace;
import io.thescenery.shopAssist.workspace.service.IWorkspaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WorkspaceController {

  private final IWorkspaceService workspaceService;

  public WorkspaceController(IWorkspaceService workspaceService) {
    this.workspaceService = workspaceService;
  }

  @GetMapping("/workspaces/{id}")
  public Workspace getWorkspaceById(@PathVariable long id) {
    return workspaceService.getWorkspaceById(id);
  }
}
