package com.peacebird.ams.controller;


import com.peacebird.ams.entity.User;
import com.peacebird.ams.result.ResultT;
import com.peacebird.ams.result.StatusCode;
import com.peacebird.ams.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;



    @PostMapping("/login")
    public ResultT login(@RequestParam String username, @RequestParam String password, HttpSession session){
        if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return  ResultT.failed(StatusCode.USERNAME_PWD_NULL);
        }
        User user = userService.queryByUserName(username);
        if (user == null){
            return  ResultT.failed(StatusCode.USERNAME_PWD_ERROR);
        }else {
            if(user.getType() != 1){
                return  ResultT.failed(StatusCode.ADMIN_USER);
            }
            if (!StringUtils.equals(user.getPassword(),password)){
                return  ResultT.failed(StatusCode.USERNAME_PWD_ERROR);
            }else{
                //登录
                session.setAttribute("CUR_USER_ID",user.getId());
                return ResultT.succed();
            }
        }
    }


    @PostMapping("/adminLogin")
    public ResultT adminLogin(@RequestParam String username, @RequestParam String password, HttpSession session){
         if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
            return  ResultT.failed(StatusCode.USERNAME_PWD_NULL);
         }
         User user = userService.queryByUserName(username);
         if(user == null){
            return  ResultT.failed(StatusCode.USERNAME_PWD_ERROR);
         }else{
             if(user.getType() != 0){
               return  ResultT.failed(StatusCode.NOT_ADMIN_USER);
             }else{
                if(!StringUtils.equals(user.getPassword(),password)){
                    return  ResultT.failed(StatusCode.USERNAME_PWD_ERROR);
                }else {
                    session.setAttribute("CUR_USER_ID", user.getId());
                    return ResultT.succed();
                }
             }
         }
    }


    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public void logout(HttpServletResponse response, HttpSession session) throws IOException {
        session.setAttribute("CUR_USER_ID",null);
        response.sendRedirect("/loginPage");
    }


    @PostMapping("/register")
    public ResultT register(@RequestParam String username,@RequestParam String mobile,
                                    @RequestParam String email,@RequestParam String password){
        User user = userService.queryByUserName(username);
        if (user != null){
            return  ResultT.failed(StatusCode.USERNAME_EXISTS);
        }
        user = new User();
        user.setUsername(username);
        user.setMobile(mobile);
        user.setEmail(email);
        user.setPassword(password);
        user.setType(1);
        int result =  userService.addUser(user);
        if(result > 0){
            return ResultT.succed();
        }
        return ResultT.failed(StatusCode.ADD_USER_ERROR);
    }













}

