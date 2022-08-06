package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @Description: mppper接口类似Dao层
 * @ClassName: UserMapper
 * @Author: xiaoranliao
 * @Date: 2022/8/6 17:34
 * @Version: 1.0
 */
public interface UserMapper {

    int insertUser();

    void updateUser();

    int deleteUser();

    User selectUser();

    List<User> selectAll();
}
