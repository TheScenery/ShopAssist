package io.thescenery.shopAssist.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.thescenery.shopAssist.app.entity.App;
import java.util.ArrayList;

public interface IAppService extends IService<App> {
  public ArrayList<App> getAppsByOwnerId(Long ownerId);
}
