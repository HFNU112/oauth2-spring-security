package com.atguigu.mapper;

import com.atguigu.entities.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-04-07
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
