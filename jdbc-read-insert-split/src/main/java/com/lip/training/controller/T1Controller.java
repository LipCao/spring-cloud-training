package com.lip.training.controller;

import com.lip.training.api.CommonResult;
import com.lip.training.mbg.model.T1;
import com.lip.training.service.T1Service;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * *****************************************************************************************
 *
 * @ClassName T1Controller
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/1/21 00:21
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       00:212/1/21     cjc                       初版
 * ******************************************************************************************
 */
@Api(tags = "测试读写分离")
@RestController
@RequestMapping("/test")
@Slf4j
public class T1Controller {

    @Autowired
    T1Service t1Service;

    @ApiOperation(" 通过🆔 获取")
    @GetMapping("/id")
    public CommonResult getById(@RequestParam(value = "id",defaultValue = "1")
                                @ApiParam("查询id")Integer id
                                ){
        T1 t1 = t1Service.selectByPrimaryKey(id);
        return CommonResult.success(t1);
    }

    @ApiOperation(" insert")
    @PostMapping("/insert")
    public CommonResult getById(@Validated @RequestBody T1 t
    ){
        CommonResult commonResult;
        int count = t1Service.insert(t);
        if (count == 1) {
            commonResult = CommonResult.success(t);
            log.debug("createBrand success:{}", t);
        } else {
            commonResult = CommonResult.failed("操作失败");
            log.debug("createBrand failed:{}", t);
        }
        T1 t1 = t1Service.selectByPrimaryKey(1);
        commonResult = CommonResult.success(t1);
        return commonResult;
    }

}
