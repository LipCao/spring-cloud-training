package com.lip.training.service.impl;

import com.lip.training.domain.CommonResult;
import com.lip.training.domain.User;
import com.lip.training.service.UserService;
import org.springframework.stereotype.Component;

/**
 * *****************************************************************************************
 *
 * @ClassName UserFallbackService
 * @Author: cjc
 * @Descripeion UserFallbackService
 * @Date： 1/24/21 20:22
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       20:221/24/21     cjc                       初版
 * ******************************************************************************************
 */
@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return new CommonResult<>(defaultUser);
    }

    @Override
    public CommonResult update(User user) {
        return new CommonResult("调用失败，服务被降级",500);
    }

    @Override
    public CommonResult delete(Long id) {
        return new CommonResult("调用失败，服务被降级",500);
    }
}
