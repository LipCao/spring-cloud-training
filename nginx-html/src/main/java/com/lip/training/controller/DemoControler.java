package com.lip.training.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * *****************************************************************************************
 *
 * @ClassName DemoControler
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 2/9/21 11:15
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       11:152/9/21     cjc                       初版
 * ******************************************************************************************
 */
@Controller
@Slf4j
public class DemoControler {

    @RequestMapping(value = "/")
    public String demo(){
        return "/index.html";
    }

    @GetMapping("/getResult")
    @ResponseBody
    public String getResult(){
        log.info("request!!!!!!");
        log.debug("debug!!!!!!");
        return "SUCCESS DEMO 1 !";
    }

    @GetMapping("/getResult2")
    @ResponseBody
    public String getResult2(){
        log.info("request!!!!!!");
        log.debug("debug!!!!!!");
        return "SUCCESS DEMO 2 !";
    }
}
