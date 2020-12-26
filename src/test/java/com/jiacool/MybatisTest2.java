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

public class MybatisTest2 {
    private OrdersMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        mapper = sqlSession.getMapper(OrdersMapper.class);
    }

    //查询所有
    @Test
    public void testFindAll(){
        List<Orders> list = mapper.findAll();
        for (Orders orders : list) {
            System.out.println(orders);
        }
    }

}
