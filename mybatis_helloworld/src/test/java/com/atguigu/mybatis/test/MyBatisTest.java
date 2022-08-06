package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description: 测试类
 * @ClassName: MyBatisTest
 * @Author: xiaoranliao
 * @Date: 2022/8/6 18:13
 * @Version: 1.0
 */
public class MyBatisTest {

    @Test
    public void  testInsert() throws IOException {
        //获取核心配置文件的输入流
        InputStream is =  Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sql的会话对象SqlSession,是MyBatis提供的操作数据库的对象
        SqlSession sqlSession = sessionFactory.openSession(true);
        //获取UserMapper的代理实现类对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法，实现添加用户信息的功能
        int result = mapper.insertUser();
        /* 提供sql以及的唯一标识找到sql并执行，唯一标识是mapper接口的映射文件中的namespace.sqlId
        int result = sqlSession.insert("com.atguigu.mybatis.mapper.UserMapper.insertUser");*/
        System.out.println("result:"+result);
        /*sessionFactory.openSession(true);是Mybaits提供的自动提交事务的方法*/
        //sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.deleteUser();
        System.out.println("result:"+result);
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUser();
        System.out.println("result:"+user.toString());
        sqlSession.close();
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.selectAll();
        userList.forEach(System.out::println);
        sqlSession.close();
    }
}
