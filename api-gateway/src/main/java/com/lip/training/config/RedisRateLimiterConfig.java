package com.lip.training.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Mono;

/**
 * *****************************************************************************************
 *
 * @ClassName RedisRateLimiterConfig
 * @Author: cjc
 * @Descripeion TODO
 * @Date： 1/25/21 23:01
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       23:011/25/21     cjc                       初版
 * ******************************************************************************************
 */
@Configuration
public class RedisRateLimiterConfig {
    @Bean
    @Primary
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
    }

    @Bean

    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
