package com.jiacool.mapper;

import com.jiacool.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
//注解方式配置开发
public interface UserMapper {
//    查询所有
    @Select("select * from user")
    public List<User> findAll();

//    插入记录
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

//    修改数据
    @Update("update user set username = #{username},password = #{password} where id = #{id}")
    public void update(User user);

//    删除数据
    @Delete("delete from user where id = #{id}")
    public void delete(int id);

//    查询一个User对象 通过id查询
    @Select("select * from user where id = #{id}")
    public User findById(int id);

//    查询一个User所具有的全部订单  一对多
    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    property = "ordersList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.jiacool.mapper.OrdersMapper.findByUid")
            )
    })
    public List<User> findUserAndOrders();


//    查询当前用户多具备的所有角色
    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "birthday", property = "birthday"),
            @Result(
                    property = "roleList",
                    column = "id",//根据哪个字段查询
                    javaType = List.class,
                    many = @Many(select = "com.jiacool.mapper.RoleMapper.findByUid")
            )

    })
    public List<User> findUserAndRole();
}
