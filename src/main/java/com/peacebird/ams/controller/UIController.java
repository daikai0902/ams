package com.peacebird.ams.controller;

import com.peacebird.ams.entity.Project;
import com.peacebird.ams.entity.User;
import com.peacebird.ams.service.IProjectService;
import com.peacebird.ams.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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




    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }


    @RequestMapping("/my/pro")
    public ModelAndView myPro(){
        ModelAndView modelAndView = new ModelAndView("myPro");
        return modelAndView;
    }


    @RequestMapping("/join/pro")
    public ModelAndView joinPro(){
        ModelAndView modelAndView = new ModelAndView("joinPro");
        return modelAndView;
    }
    
    @GetMapping("/pro/api/manage/{proId}")
    public ModelAndView apiManage(@PathVariable Integer proId){
        ModelAndView modelAndView = new ModelAndView("apiManage");
        Project project = projectService.selectById(proId);
        modelAndView.addObject("project",project);
        return modelAndView;
    }










}
