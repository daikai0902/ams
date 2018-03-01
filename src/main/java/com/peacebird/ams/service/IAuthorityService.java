package com.peacebird.ams.service;

import com.baomidou.mybatisplus.service.IService;
import com.peacebird.ams.entity.Authority;
import com.peacebird.ams.entity.Project;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kevin.dai
 * @since 2018-01-25
 */
public interface IAuthorityService extends IService<Authority> {


    int addAuthority(Authority authority);


    int editAuthorityById(Authority authority);


    Authority selectById(Integer id);

}
