package com.peacebird.ams.dao;

import com.peacebird.ams.entity.Project;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 *
 * 项目管理相关接口
 * @author kevin.dai
 * @since 2018-01-25
 */

@Mapper
@Repository
public interface ProjectMapper extends BaseMapper<Project> {

    int addProject(Project project);

}
