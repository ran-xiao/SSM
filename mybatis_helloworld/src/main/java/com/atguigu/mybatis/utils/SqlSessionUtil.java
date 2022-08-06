package com.atguigu.mybatis.utils;

import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: sql工具类
 * @ClassName: SqlSessionUtil
 * @Author: xiaoranliao
 * @Date: 2022/8/6 23:58
 * @Version: 1.0
 */
public class SqlSessionUtil {

    public static SqlSession getSqlSession(){

        SqlSession sqlSession = null;
        try {
            //获取核心配置文件的输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SqlSessionFactoryBuider
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取SqlSession
            sqlSession = sqlSessionFactory.openSession(true);
            /*//获取mapper接口的代理实现类
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);*/
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;

    }

}
