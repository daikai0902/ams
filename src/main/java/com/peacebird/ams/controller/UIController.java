package com.peacebird.ams.controller;

import com.peacebird.ams.entity.Project;
import com.peacebird.ams.entity.User;
import com.peacebird.ams.service.IProjectService;
import com.peacebird.ams.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 *
 * 视图控制器
 * @autor kevin.dai
 * @Date 2018/1/22
 */


@Controller
public class UIController {

    @Autowired
    private IUserService userService;


    @Autowired
    private IProjectService projectService;


    @GetMapping("/loginPage")
    public String login(){
        return "login";
    }


    @ModelAttribute("curUser")
    public User currentUser(HttpSession session){
        Integer userId = (Integer)session.getAttribute("CUR_USER_ID");
        if (userId == null){
            return null;
        }
        User user = userService.queryByUserId(userId);
        return user;
    }




    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }



    @GetMapping("/ams/pro/me")
    public ModelAndView myPro(){
        ModelAndView modelAndView = new ModelAndView("myPro");
        return modelAndView;
    }


    @GetMapping("/ams/pro/join")
    public ModelAndView joinPro(){
        ModelAndView modelAndView = new ModelAndView("joinPro");
        return modelAndView;
    }



    @GetMapping("/ams/pro/menu")
    public ModelAndView projectLeftMenu(){
        ModelAndView modelAndView = new ModelAndView("projectMenu");
        return modelAndView;
    }
    
    
    @GetMapping("/ams/pro/base/info/{proId}")
    public ModelAndView baseInfo(@PathVariable Integer proId){
        ModelAndView modelAndView = new ModelAndView("baseInfo");
        Project project = projectService.selectById(proId);
        modelAndView.addObject("project",project);
        return modelAndView;
    }


    @GetMapping("/ams/pro/role/{proId}")
    public ModelAndView roleManege(@PathVariable Integer proId){
        ModelAndView modelAndView = new ModelAndView("roleManage");
        Project project = projectService.selectById(proId);
        modelAndView.addObject("project",project);
        return modelAndView;
    }



    @GetMapping("/ams/pro/member/{proId}")
    public ModelAndView memberManege(@PathVariable Integer proId){
        ModelAndView modelAndView = new ModelAndView("memberManage");
        Project project = projectService.selectById(proId);
        modelAndView.addObject("project",project);
        return modelAndView;
    }


    
    /**
     * 接口管理
     * @Date: 13:56 2018/2/1
     */
    @GetMapping("/ams/pro/api/manage/{proId}")
    public ModelAndView apiManage(@PathVariable Integer proId){
        ModelAndView modelAndView = new ModelAndView("apiManage");
        Project project = projectService.selectById(proId);
        modelAndView.addObject("project",project);
        return modelAndView;
    }




    
    /**
     * 消息中心
     * @Date: 17:18 2018/2/1
     */
    @GetMapping("/ams/message")
    public ModelAndView messageCenter(){
        ModelAndView modelAndView = new ModelAndView("messageCenter");
        return modelAndView;
    }








}
