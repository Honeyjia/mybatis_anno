package com.jiacool.mapper;

import com.jiacool.domain.Orders;
import com.jiacool.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper {

    /*@Select("select * ,o.id oid from orders o,user u where o.uid = u.id ")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password"),

    })*/

    @Select("select * from orders")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user",//要封装的属性名称
                    column = "uid",//根据哪个字段去查询user表的数据
                    javaType = User.class,  //要封装的实体类型
                    //select属性: 代表查询哪个接口的方法获得数据(方法的全限名)
                    one = @One(select = "com.jiacool.mapper.UserMapper.findById")
            )
    })
    public List<Orders> findAll();

//    通过uid查询记录
    @Select("select * from orders where uid = #{uid}")
    public List<Orders> findByUid(int uid);
}
