package com.shoping.dao;

import com.shoping.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    String selectQuestionByUsername(String username);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    int updatePasswordByUserName(@Param("username") String username, @Param("passwordNew") String passwordNew);

    int checkUserName(String username);

    int checkEmail(String email);

    int checkEmailByUserId(@Param("email")String email, @Param("userId")Integer userId);

    int checkAnswer(@Param("username")String username, @Param("question")String question, @Param("answer")String answer);

    int checkPassword(@Param("password")String password, @Param("userId")Integer userId);


//    生成代码
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}