package com.peacebird.ams.result;

import com.peacebird.ams.entity.Project;
import com.peacebird.ams.util.CommonUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor kevin.dai
 * @Date 2018/1/26
 */
public class ProjectVO  extends BaseVO{


    public Integer id;

    public String name;

    public String status;

    public String createTime;

    public String describes;


    public ProjectVO(){

    }


    public ProjectVO (Project project){
        this.id = project.getId();
        this.name = project.getName();
        this.status =project.getStatus() == 0?"关闭":"开启";
        this.createTime = CommonUtils.formatDate(project.getCreateTime(),"yyyy-MM-dd HH:MM:SS");
        this.describes = project.getDescribes();
    }


    public static  List<ProjectVO> toVOs(List<Project> projects){
        if(projects ==null ||projects.size()<1){
            return Collections.emptyList();
        }
        return projects.stream().map(p -> new ProjectVO(p)).collect(Collectors.toList());
    }






}
