package com.peacebird.ams.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.peacebird.ams.dao.AuthorityMapper;
import com.peacebird.ams.dao.ProjectMapper;
import com.peacebird.ams.entity.Authority;
import com.peacebird.ams.entity.Project;
import com.peacebird.ams.service.IAuthorityService;
import com.peacebird.ams.service.IProjectService;
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
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements IAuthorityService {


    @Override
    public int addAuthority(Authority authority) {
        return this.baseMapper.insert(authority);
    }


    @Override
    public int editAuthorityById(Authority authority){
        return this.baseMapper.updateById(authority);
    }


    @Override
    public Authority selectById(Integer id) {
        return super.selectById(id);
    }
}
