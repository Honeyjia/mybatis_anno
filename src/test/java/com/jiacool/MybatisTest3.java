package com.jiacool;

import com.jiacool.domain.Orders;
import com.jiacool.domain.User;
import com.jiacool.mapper.OrdersMapper;
import com.jiacool.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest3 {
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    //查询所有 一对多
    @Test
    public void testFindAll(){
        List<User> all = mapper.findUserAndOrders();
        for (User user : all) {
            System.out.println(user);
        }
    }
}
