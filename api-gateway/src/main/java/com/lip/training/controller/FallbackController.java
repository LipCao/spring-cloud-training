package com.lip.training.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * *****************************************************************************************
 *
 * @ClassName FallbackController
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 1/25/21 22:44
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       22:441/25/21     cjc                       初版
 * ******************************************************************************************
 */
@RestController
public class FallbackController {
    @GetMapping("/fallback")
    public Object fallback() {
        Map<String,Object> result = new HashMap<>();
        result.put("data",null);
        result.put("message","Get request fallback!");
        result.put("code",500);
        return result;
    }
}
