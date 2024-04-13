package com.atguigu.service;

import com.atguigu.entities.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-04-07
 */
public interface IUserService extends IService<User> {

    void addUserDetails(User user);

    void deleteUserDetails(String username);
}
