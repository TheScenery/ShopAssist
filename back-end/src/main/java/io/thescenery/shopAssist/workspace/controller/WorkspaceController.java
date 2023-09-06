package io.thescenery.shopAssist.workspace.controller;

import io.thescenery.shopAssist.workspace.entity.Workspace;
import io.thescenery.shopAssist.workspace.service.IWorkspaceService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class WorkspaceController {
  @Resource
  private IWorkspaceService workspaceService;
  @GetMapping("/workspaces/{id}")
  public Workspace getWorkspaceById(@PathVariable long id) {
    return workspaceService.getWorkspaceById(id);
  }
}
