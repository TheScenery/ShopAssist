package io.thescenery.shopAssist.workspace.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.thescenery.shopAssist.workspace.entity.Workspace;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkspaceMapper extends BaseMapper<Workspace> {

  Workspace getWorkspaceById(Long id);

  ArrayList<Workspace> getWorkspacesByOwnerId(Long ownerId);

  long createWorkspace(Workspace workspace);
}
