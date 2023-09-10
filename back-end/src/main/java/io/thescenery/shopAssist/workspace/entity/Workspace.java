package io.thescenery.shopAssist.workspace.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_workspace")
public class Workspace {

  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;
  private String name;
  private Long ownerId;
}
