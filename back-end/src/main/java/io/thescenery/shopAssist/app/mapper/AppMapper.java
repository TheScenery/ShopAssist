package io.thescenery.shopAssist.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.thescenery.shopAssist.app.entity.App;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppMapper extends BaseMapper<App> {
  public ArrayList<App> getAppsByOwnerId(Long ownerId);
}
