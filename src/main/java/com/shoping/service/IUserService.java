package com.shoping.service;

import com.shoping.common.ServerResponse;
import com.shoping.pojo.User;

/**
 * @author perkins
 */
public interface IUserService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    ServerResponse<User> login(String username, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    ServerResponse<String> register(User user);

    /**
     * 校验用户名或Email是否存在
     * @param str
     * @param type
     * @return
     */
    ServerResponse<String> checkValid(String str, String type);

    /**
     * 查询找回密码问题
     * @param username
     * @return
     */
    ServerResponse<String> selectQuestion(String username);

    /**
     * 校验忘记密码问题答案是否正确
     * @param username
     * @param question
     * @param answer
     * @return
     */
    ServerResponse<String> checkQuestion(String username,String question,String answer);

    /**
     * 忘记密码重置密码
     * @param username
     * @param newPassword
     * @param forgetToken
     * @return
     */
    ServerResponse<String> forgetResetPassword(String username, String newPassword, String forgetToken);

    /**
     * 重置密码
     * @param oldPassword
     * @param newPassword
     * @param user
     * @return
     */
    ServerResponse<String> resetPassword(String oldPassword, String newPassword, User user);

    /**
     * 更新个人用户信息
     * @param user
     * @return
     */
    ServerResponse<User> updateUserInfo(User user);
}
