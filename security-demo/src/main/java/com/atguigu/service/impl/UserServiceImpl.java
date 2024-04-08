package com.atguigu.service.impl;

import com.atguigu.entities.User;
import com.atguigu.mapper.UserMapper;
import com.atguigu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
