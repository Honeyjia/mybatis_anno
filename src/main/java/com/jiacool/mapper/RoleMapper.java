package com.jiacool.mapper;

import com.jiacool.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    //通过uid 查询 sys_user_role 和 sys_role 表
    @Select("select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = #{uid}")
    public List<Role> findByUid(int uid);
}
