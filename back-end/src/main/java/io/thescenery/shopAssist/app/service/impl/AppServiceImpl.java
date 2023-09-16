package io.thescenery.shopAssist.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.thescenery.shopAssist.app.entity.App;
import io.thescenery.shopAssist.app.mapper.AppMapper;
import io.thescenery.shopAssist.app.service.IAppService;
import java.util.ArrayList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppServiceImpl extends ServiceImpl<AppMapper, App> implements IAppService {

  private final AppMapper appMapper;

  @Override
  public ArrayList<App> getAppsByOwnerId(Long ownerId) {
    return appMapper.getAppsByOwnerId(ownerId);
  }
}
