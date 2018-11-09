package com.shoping.controller.backend;

import com.shoping.common.Const;
import com.shoping.common.ServerResponse;
import com.shoping.pojo.User;
import com.shoping.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author perkins
 */
@Controller
@RequestMapping("/manage/user")
public class UserManagerController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> login(String username, String password, HttpSession session) {
        ServerResponse response = iUserService.login(username,password);
        if (response.isSuccess()) {
            User user = (User) response.getData();
            if (Const.Role.ROLE_ADMIN == user.getRole()) {
                session.setAttribute(Const.CURRENT_USER, user);
                return response;
            } else {
                return ServerResponse.createByErrorMessage("不是管理员，无法登录");
            }
        }
        return response;
    }
}
