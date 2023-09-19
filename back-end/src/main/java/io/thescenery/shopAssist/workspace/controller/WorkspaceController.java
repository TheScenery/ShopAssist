package io.thescenery.shopAssist.workspace.controller;

import io.thescenery.shopAssist.workspace.dto.CreateWorkspaceRequestDto;
import io.thescenery.shopAssist.workspace.entity.Workspace;
import io.thescenery.shopAssist.workspace.service.IWorkspaceService;
import java.util.ArrayList;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping("/workspaces/create")
  public Workspace createWorkspace(@RequestBody CreateWorkspaceRequestDto dto) {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    Long userId = (Long) authentication.getPrincipal();
    return workspaceService.createWorkspace(
        Workspace.builder().name(dto.getName()).ownerId(userId).build());
  }

  @GetMapping("/workspaces/my-workspaces")
  public ArrayList<Workspace> getMyWorkspaces() {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    Long userId = (Long) authentication.getPrincipal();
    return workspaceService.getWorkspacesByOwnerId(userId);
  }
}
