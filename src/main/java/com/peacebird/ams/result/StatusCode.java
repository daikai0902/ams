package com.peacebird.ams.result;

/**
 * @autor kevin.dai
 * @Date 2018/1/24
 */
public class StatusCode {


    public final static Object[] succed = {2000,"请求成功"};


    public final static Object[] USERNAME_PWD_NULL = {3001,"用户名或密码为空！"};

    public final static Object[] USERNAME_PWD_ERROR = {3002,"用户名或密码错误！"};

    public final static Object[] USERNAME_EXISTS = {3003,"用户名已经存在！"};

    public final static Object[] ADD_USER_ERROR = {3004,"新增用户错误！"};

    public final static Object[] NOT_ADMIN_USER = {3005,"仅限管理员登录！"};

    public final static Object[] ADMIN_USER = {3006,"用户角色为管理员！"};
}
