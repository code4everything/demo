package com.zhazhapan.demo.springboot.shiro.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.code4everything.boot.bean.ResponseResult;
import org.code4everything.boot.web.mvc.BaseController;
import org.springframework.web.bind.annotation.*;

/**
 * @author pantao
 * @since 2018-12-11
 */
@Api
@RestController
@RequestMapping("/")
public class UserController extends BaseController {

    @ApiOperation("")
    @GetMapping("/get")
    @RequiresPermissions("res:get")
    public ResponseResult<String> get() {
        return successResult("获取资源成功");
    }

    @ApiOperation("")
    @DeleteMapping("/delete")
    @RequiresPermissions("res:delete")
    public ResponseResult<String> delete() {
        return successResult("删除成功");
    }

    @ApiOperation("")
    @PostMapping("/login")
    public ResponseResult<String> login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        return successResult("登录成功");
    }

    @ApiOperation("")
    @DeleteMapping("/logout")
    public ResponseResult<String> logout() {
        SecurityUtils.getSubject().logout();
        return successResult("登出成功");
    }
}
