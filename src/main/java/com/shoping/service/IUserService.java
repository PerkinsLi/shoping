package com.shoping.service;

import com.shoping.common.ServerResponse;
import com.shoping.pojo.User;

/**
 * @Author: perkins
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
}
