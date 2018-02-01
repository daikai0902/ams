package com.peacebird.ams.service;

import com.peacebird.ams.entity.Project;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kevin.dai
 * @since 2018-01-25
 */
public interface IProjectService extends IService<Project> {


    int addProject(Project project);

}
