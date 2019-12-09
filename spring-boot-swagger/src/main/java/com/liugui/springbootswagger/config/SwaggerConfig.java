package com.liugui.springbootswagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.annotation.Documented;

/**
 * @ClassName: SwaggerConfig
 * @Author: liugui
 * @Date: 2019-12-09 14:09
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liugui.springbootswagger"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().title("springboot 集成 swagger")
                        .description("springboot 集成 swagger 描述")
                        .version("0.1.1")
                        .contact(new Contact("liugui", "null", "13539506534@163.com"))
                        .build());
    }

}
