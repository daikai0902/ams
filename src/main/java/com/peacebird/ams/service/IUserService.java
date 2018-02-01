package com.peacebird.ams.service;

import com.peacebird.ams.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kevin.dai
 * @since 2018-01-24
 */
public interface IUserService extends IService<User> {


    User queryByUserId(Integer id);

    User queryByUserName(String username);

    int addUser(User user);


}
