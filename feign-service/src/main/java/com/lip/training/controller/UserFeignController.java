package com.lip.training.controller;

import com.lip.training.domain.CommonResult;
import com.lip.training.domain.User;
import com.lip.training.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * *****************************************************************************************
 *
 * @ClassName UserFeignController
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 1/23/21 16:56
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       16:561/23/21     cjc                       初版
 * ******************************************************************************************
 */
@Api(tags = "测试 open feign")
@RestController
@RequestMapping("/usert")
public class UserFeignController {

    @Autowired
    private UserService userService;

    @ApiOperation(" getUser ")
    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    public CommonResult getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}
