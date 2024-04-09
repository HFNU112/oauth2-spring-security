package com.atguigu.controller;

import com.atguigu.common.ResultData;
import com.atguigu.entities.User;
import com.atguigu.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shunpeng.hu
 * @since 2024-04-07
 */
@RestController
@RequestMapping("/user")
@Tag(name = "用户服务模块", description = "用户服务CRUD")
public class UserController {

    @Resource
    private IUserService userService;

    @Operation(summary = "查询", description = "查询用户列表")
    @GetMapping("/list")
    public ResultData<List<User>> getList(){
        List<User> userList = userService.list();
        return ResultData.success(userList);
    }

    @Operation(summary = "新增", description = "新增用户")
    @PostMapping("/add")
    public void addUserDetails(@RequestBody @Parameter User user){
        userService.addUserDetails(user);
    }

}
