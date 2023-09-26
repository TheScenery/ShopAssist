package io.thescenery.shopAssist.app.controller;

import io.thescenery.shopAssist.app.dto.CreateAppDto;
import io.thescenery.shopAssist.app.entity.App;
import io.thescenery.shopAssist.app.service.IAppService;
import io.thescenery.shopAssist.util.AuthUtil;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AppController {

  private final IAppService appService;

  @GetMapping("/app/my-apps")
  public ArrayList<App> getMyApps() {
    Authentication authentication = SecurityContextHolder.getContext()
        .getAuthentication();
    Long userId = (Long) authentication.getPrincipal();
    return appService.getAppsByOwnerId(userId);
  }

  @PostMapping("/app/create")
  public App createApp(@RequestBody CreateAppDto dto) {
    Long userId = AuthUtil.getCurrentUserId();
    App app = App.builder().ownerId(userId).name(dto.getName()).build();
    appService.createApp(app);
    return app;
  }
}
