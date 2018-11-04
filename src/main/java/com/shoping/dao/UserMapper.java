package com.shoping.dao;

import com.shoping.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectLogin(@Param("username") String username, @Param("password") String password);

    int checkUserName(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}