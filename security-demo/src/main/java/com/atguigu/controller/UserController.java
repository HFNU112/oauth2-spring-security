package com.atguigu.controller;

import com.atguigu.common.ResultData;
import com.atguigu.entities.User;
import com.atguigu.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN') and authentication.name == 'admin'")
    @GetMapping("/list")
    public ResultData<List<User>> getList(){
        List<User> userList = userService.list();
        return ResultData.success(userList);
    }

    @Operation(summary = "新增", description = "新增用户")
//    @PreAuthorize("hasRole('COMMON')")
    @PreAuthorize("hasAuthority('USER_ADD')")
    @PostMapping("/add")
    public ResultData<String> addUserDetails(@RequestBody @Parameter User user){
        userService.addUserDetails(user);
        return ResultData.success("新增成功");
    }

    @Operation(summary = "删除", description = "删除用户")
    @PreAuthorize("hasAuthority('USER_DELETE')")
    @DeleteMapping("/delete/{id}")
    public ResultData<String> deleteUserDetails(@PathVariable(value = "id") Long id){
        userService.deleteUserDetails(id);
        return ResultData.success("删除成功");
    }

    @Operation(summary = "修改", description = "修改用户")
    @PutMapping("/update")
    public ResultData<String> updateUserDetails(@RequestBody @Parameter User user){
        userService.updateUserDetails(user);
        return ResultData.success("修改成功");
    }
}
