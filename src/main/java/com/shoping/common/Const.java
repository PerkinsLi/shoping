package com.shoping.common;


/**
 * @Author: perkins
 */
public class Const {
    public static final String CURRENT_USER = "CURRENT_USER";
    public static final String EMAIL = "email";
    public static final String USER_NAME = "username";

    public interface Role{
        /**
         * 普通用户
         */
        int ROLE_CUSTOMER = 0;
        /**
         * 管理员
         */
        int ROLE_ADMIN = 1;
    }
}
