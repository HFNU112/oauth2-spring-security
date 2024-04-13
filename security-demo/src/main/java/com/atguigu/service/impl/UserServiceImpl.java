package com.atguigu.service.impl;

import com.atguigu.config.DBUserDetailsManager;
import com.atguigu.entities.User;
import com.atguigu.mapper.UserMapper;
import com.atguigu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-04-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private DBUserDetailsManager dbUserDetailsManager;

    @Override
    public void addUserDetails(User user) {
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withDefaultPasswordEncoder()
                .username(user.getUsername())  //新增参数账号
                .password(user.getPassword())  //新增参数密码
                .build();
        dbUserDetailsManager.createUser(userDetails);
    }

    @Override
    public void deleteUserDetails(String username) {
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(username)
                .build();
        dbUserDetailsManager.deleteUser(userDetails.getUsername());
    }
}
