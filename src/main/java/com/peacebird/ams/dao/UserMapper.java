package com.peacebird.ams.dao;

import com.peacebird.ams.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户相关接口
 * @author kevin.dai
 * @since 2018-01-24
 */

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    User queryByUserId(Integer id);

    User queryByUserName(String username);


    int addUser(User user);





}
