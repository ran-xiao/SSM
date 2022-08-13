package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Description: 实体类
 * @ClassName: UserMapper
 * @Author: xiaoranliao
 * @Date: 2022/8/13 16:56
 * @Version: 1.0
 */
public interface UserMapper {
    /**
     *  根据用户名查询用户信息
     *
     * @author xiaoranliao 
     * @param username: 
     * @return [java.lang.String]
     * @date 2022/8/13 17:09
     */
    
    User getUserByUsername(String username);

    User checkLogin(String username,String password);

    User checkLoginByMap(Map<String ,Object> map);

    void insertUser(User user);
    /**
     *  验证登录（@param注解）
     *
     * @author xiaoranliao 
     * @param username:
     * @param password: 
     * @return [java.lang.String, java.lang.String]
     * @date 2022/8/13 17:54
     */
    
    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
