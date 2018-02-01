package com.peacebird.ams.service.impl;

import com.peacebird.ams.entity.User;
import com.peacebird.ams.dao.UserMapper;
import com.peacebird.ams.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kevin.dai
 * @since 2018-01-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public User queryByUserName(String username) {
        return this.baseMapper.queryByUserName(username);
    }


    @Override
    public int addUser(User user) {
        return this.baseMapper.addUser(user);
    }


    @Override
    public User queryByUserId(Integer id) {
        return this.baseMapper.queryByUserId(id);
    }
}
