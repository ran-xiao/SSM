package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Description: 测试
 * @ClassName: ParameterTest
 * @Author: xiaoranliao
 * @Date: 2022/8/13 17:13
 * @Version: 1.0
 */
public class ParameterTest {

    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUsername("root");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("root","12323");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username","root");
        map.put("password","12323");
        User user = userMapper.checkLoginByMap(map);
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
         SqlSession sqlSession = SqlSessionUtil.getSqlSession();
         UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
         User user = new User(null,"glory","0723",25,"女","wewew@163.com");
         userMapper.insertUser(user);
         System.out.println(user);

    }

    @Test
    public void testCheckLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"glory","0723",25,"女","wewew@163.com");
        user = userMapper.checkLoginByParam(user.getUsername(),user.getPassword());
        System.out.println(user);

    }
}
