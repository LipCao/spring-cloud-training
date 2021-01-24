package com.lip.training.config;

import com.google.common.collect.Sets;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang.reflect.FieldUtils;
import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

/**
 * *****************************************************************************************
 *
 * @ClassName SwaggerConfig
 * @Author: cjc
 * @Descripeion swagger
 * @Date： 2020/12/25 上午10:19
 * @Version 1.0
 * <p>
 * <p>
 * Version    Date                ModifiedBy                 Content
 * --------   ---------           ----------                -----------------------
 * 1.0.0       上午10:192020/12/25     cjc                       初版
 * ******************************************************************************************
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig implements WebMvcConfigurer {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .pathMapping("/")
                // 定义是否开启swagger，false为关闭，可以通过变量控制
                .enable(true)
                // 将api的元信息设置为包含在json ResourceListing响应中。
                .apiInfo(apiInfo())
                // 接口调试地址
                .host("http://localhost:8081")
                // 选择哪些接口作为swagger的doc发布
                .select()
                //.apis(RequestHandlerSelectors.c("com.lip.aop.controller"))
                //为有@Api注解的Controller生成API文档
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                // 支持的通讯协议集合
                .protocols(Sets.newHashSet("http", "https"))
                // 授权信息设置，必要的header token等认证信息
                .securitySchemes(securitySchemes())
                // 授权信息全局应用
                .securityContexts(securityContexts());
    }

    /** API 页面上半部分展示信息 */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(" Api Doc")
                .description("SpringFox 3.0.0 发布: https://127.0.0.1:8081/swagger-ui/index.html")
                .contact(new Contact("lighter", null, "saycjc@outlook.com"))
                .version(
                        "Application Version: "
                                + "1.0.0"
                                + ", Spring Boot Version: "
                                + SpringBootVersion.getVersion())
                .build();
    }

    /** 设置授权信息
     * @return*/
    private List<SecurityScheme> securitySchemes() {
        ApiKey apiKey = new ApiKey("BASE_TOKEN", "token", In.HEADER.toValue());
        return Collections.singletonList(apiKey);
    }

    /** 授权信息全局应用 */
    private List securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(
                                Collections.singletonList(
                                        new SecurityReference(
                                                "BASE_TOKEN",
                                                new AuthorizationScope[] {new AuthorizationScope("global", "")})))
                        .build());
    }

    /** 通用拦截器排除swagger设置，所有拦截器都会自动加swagger相关的资源排除信息 */
    @SuppressWarnings("unchecked")
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        try {
            Field registrationsField =
                    FieldUtils.getField(InterceptorRegistry.class, "registrations", true);
            List<InterceptorRegistration> registrations =
                    (List<InterceptorRegistration>) ReflectionUtils.getField(registrationsField, registry);
            if (registrations != null) {
                for (InterceptorRegistration interceptorRegistration : registrations) {
                    interceptorRegistration
                            .excludePathPatterns("/swagger**/**")
                            .excludePathPatterns("/webjars/**")
                            .excludePathPatterns("/v3/**")
                            .excludePathPatterns("/doc.html");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
