package com.peacebird.ams.service.impl;

import com.peacebird.ams.entity.Project;
import com.peacebird.ams.dao.ProjectMapper;
import com.peacebird.ams.service.IProjectService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kevin.dai
 * @since 2018-01-25
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {


    @Override
    public int addProject(Project project) {
        return this.baseMapper.addProject(project);
    }
}
