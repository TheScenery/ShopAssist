package io.thescenery.shopAssist.mapper;

import io.thescenery.shopAssist.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user WHERE id = #{id}")
    User getUserById(@Param("id") int id);
}
