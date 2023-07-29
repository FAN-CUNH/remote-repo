package com.fch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @packageName com.fch.config
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 18:34
 * @Version 1.0
 */
@Configuration
public class SwaggerConfig {
    @Value("${spring.swagger2.enable}")
    private Boolean enabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fch.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger2构建api接口文档 "+"\t"+ DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDateTime.now()))
                .description("springboot+redis整合,有问题给管理员邮件:582389514@qq.com")
                .version("1.0")
                .termsOfServiceUrl("https://www.fch.com")
                .build();
    }
}
