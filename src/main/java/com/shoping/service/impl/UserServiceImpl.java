package com.shoping.service.impl;

import com.shoping.common.Const;
import com.shoping.common.ServerResponse;
import com.shoping.dao.UserMapper;
import com.shoping.pojo.User;
import com.shoping.service.IUserService;
import com.shoping.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: perkins
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ServerResponse<User> login(String username, String password) {
        int resultCount = userMapper.checkUserName(username);
        if (resultCount == 0) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }

        // 密码登录MD5
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        User user = userMapper.selectLogin(username,md5Password);
        if (user == null) {
            return ServerResponse.createByErrorMessage("密码错误");
        }

        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createBySuccessMessage("登录成功",user);
    }

    @Override
    public ServerResponse<String> register(User user) {
        ServerResponse<String> responseValid = checkValid(user.getUsername(),Const.USER_NAME);
        if (!responseValid.isSuccess()){
            return responseValid;
        }

        responseValid = checkValid(user.getUsername(),Const.EMAIL);
        if (!responseValid.isSuccess()){
            return responseValid;
        }

        user.setRole(Const.Role.ROLE_CUSTOMER);
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));

        int resultCountInsert = userMapper.insert(user);
        if (resultCountInsert == 0) {
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
    public ServerResponse<String> checkValid(String str, String type) {
        if (StringUtils.isNotBlank(type)){
            if (Const.EMAIL.equals(type)){
                int resultCountUsername = userMapper.checkUserName(str);
                if (resultCountUsername > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }

            if (Const.USER_NAME.equals(type)){
                int resultCountUsername = userMapper.checkEmail(str);
                if (resultCountUsername > 0) {
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
        }else {
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }
}
