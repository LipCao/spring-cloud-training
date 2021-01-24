package com.lip.training.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * *****************************************************************************************
 *
 * @ClassName FeignConfig
 * @Author: cjc
 * @Descripeion 我们通过java配置来使Feign打印最详细的Http请求日志信息。
 * @Date： 1/24/21 20:28
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       20:281/24/21     cjc                       初版
 * ******************************************************************************************
 */
@Configuration
public class FeignConfig {
    /*NONE：默认的，不显示任何日志；
    BASIC：仅记录请求方法、URL、响应状态码及执行时间；
    HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息；
    FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。*/
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
