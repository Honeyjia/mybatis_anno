package com.jiacool;

import com.jiacool.domain.User;
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

public class MybatisTest {
    private UserMapper mapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    //查询所有
    @Test
    public void testFindAll(){
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    //插入数据
    @Test
    public void testSave(){
       //模拟User对象
        User user = new User();
        user.setUsername("lu");
        user.setPassword("872873");
        mapper.save(user);
    }

//    修改数据
    @Test
    public void testUpdate(){
        //模拟User对象
        User user = new User();
        user.setId(5);
        user.setUsername("lucy");
        user.setPassword("nbn");
        mapper.update(user);
    }

    //删除数据
    @Test
    public void testDelete(){
        mapper.delete(8);
    }

    //查找一个User对象
    @Test
    public void testFindById(){
        User user = mapper.findById(5);
        System.out.println(user);

    }
}
