package com.lip.training.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lip.training.domain.CommonResult;

/**
 * Created by macro on 2019/11/7.
 */
public class CustomBlockHandler {

    public CommonResult handleException(BlockException exception){
        return new CommonResult("自定义限流信息",200);
    }
}
