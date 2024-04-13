package com.atguigu.config;

import com.atguigu.entities.User;
import com.atguigu.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * 自定义数据库身份认证管理类
 * @Author Husp
 * @Date 2024/4/8 23:50
 */
@Slf4j
@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return user;  //  return null 出现空指针异常 Cannot invoke "org.springframework.security.core.userdetails.UserDetails.getAuthorities()"
    }

    /**
     * 添加用户
     * @param userDetails security用户对象
     */
    @Override
    public void createUser(UserDetails userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        userMapper.insert(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    /**
     * 删除用户
     * @param username
     */
    @Override
    public void deleteUser(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);

        userMapper.delete(wrapper);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    /**
     * 通过数据库名校验用户信息是否合法
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Collection<GrantedAuthority> authorities = new ArrayList<>(10);

        //查询数据库的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = userMapper.selectOne(wrapper);
        if (Objects.isNull(user)) {
            log.error("数据库中不存在该用户啦~");
            throw new UsernameNotFoundException(username);
        } else {
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(), //用户名
                    user.getPassword(), //密码
                    (user.getEnabled() == 1),  //用户是否启用 true：启用
                    true,   //帐户未过期 true：账户没有过期
                    true,   //凭据是否未过期 true：凭据没有过期
                    true,   //帐号是否未锁定 true：账户没有锁定
                    authorities   //授予用户的权限
            );
        }
    }
}
