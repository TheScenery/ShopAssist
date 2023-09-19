package io.thescenery.shopAssist.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("t_app")
public class App {

  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;
  private String name;
  private Long ownerId;
  private Boolean isDeleted;
  private Date createTime;
  private Date updateTime;
}
