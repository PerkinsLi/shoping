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
}
