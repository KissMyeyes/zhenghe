package com.example.wwmd.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:9090/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                .apis(RequestHandlerSelectors.basePackage("com.example.wwmd.controller"))
//                .apis(RequestHandlerSelectors.basePackage("com.wangwei.controller,com.wangwei.service"))
//                允许所有
//                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                 // 文档标题
                .title("wangwei的Spring Boot restAPI")
                // 文档描述
                .description("https://github.com/KissMyeyes")
                .termsOfServiceUrl("https://github.com/KissMyeyes")
                .version("v1")
                .build();
    }

}