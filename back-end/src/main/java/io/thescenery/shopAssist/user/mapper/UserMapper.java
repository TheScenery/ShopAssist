package io.thescenery.shopAssist.user.mapper;

import io.thescenery.shopAssist.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUserById(@Param("id") int id);
}
