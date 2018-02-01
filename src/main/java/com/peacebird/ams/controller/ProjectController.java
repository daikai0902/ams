package com.peacebird.ams.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.peacebird.ams.entity.Project;
import com.peacebird.ams.result.LayResultT;
import com.peacebird.ams.result.ProjectVO;
import com.peacebird.ams.result.ResultT;
import com.peacebird.ams.service.IProjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 项目管理
 * @author kevin.dai
 * @since 2018-01-25
 */
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;




    @PostMapping("/add")
    public ResultT addProject(@RequestParam String name, @RequestParam String describe,
                              @RequestParam  Integer status, HttpSession session){
        Integer creator = (Integer) session.getAttribute("CUR_USER_ID");
        Project project = new Project();
        project.setName(name);
        project.setDescribes(describe);
        project.setStatus(status);
        project.setCreatorId(creator);
        project.setCreateTime(new Date());

        int result = projectService.addProject(project);
        if(result >0){
            return ResultT.succed();
        }
        return ResultT.failed("新增项目失败！");
    }



    @GetMapping("/my/list")
    public LayResultT myProList(@RequestParam  int page,@RequestParam  int limit,
                                    @RequestParam(required = false) String projectName, HttpSession session){
        Integer creatorId = (Integer) session.getAttribute("CUR_USER_ID");
        EntityWrapper<Project> ew = new EntityWrapper<Project>();
        ew.setEntity(new Project());
        ew.where("creator_id={0}",creatorId);
        if(StringUtils.isNotBlank(projectName)){
            ew.and().like(" name ",projectName);
        }

        Page<Project> prs = projectService.selectPage(new Page<>(page,limit),ew);
        List<Project> projects = prs.getRecords();
        List<ProjectVO> projectVOS = ProjectVO.toVOs(projects);
        int count =  projectService.selectCount(ew);
        return new LayResultT(projectVOS,count);


    }














}

