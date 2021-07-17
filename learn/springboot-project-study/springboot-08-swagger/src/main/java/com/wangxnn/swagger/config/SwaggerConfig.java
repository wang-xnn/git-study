package com.wangxnn.swagger.config;

import io.swagger.annotations.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean //配置了Swagger的 docket 的bean实例
    public Docket docket(Environment environment){
        // 设置要显示的Swagger环境
         Profiles profiles= Profiles.of("dev","test");
        // 通过environment.acceptsProfiles判断是否处于自己设定的环境中
         boolean isDev = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo())
                .enable(isDev) //enable确定是否开启swagger，如果为false,则不能启动swagger
                .select().apis(RequestHandlerSelectors.basePackage("com.wangxnn.swagger.controller"))
                // 过滤，只扫描指定的路径下的接口
                //.paths(PathSelectors.ant("/wangxnn/**"))
                .build();
    }
    // 配置swagger中的 apiInfo信息
    private  ApiInfo apiInfo(){
        Contact contact = new Contact("wangxnn","https://leetcode-cn" +
                ".com/problems/maximum-product-subarray/solution/","252279128@qq.com");
        return new ApiInfo("Wangxnn learn Swagger Api Documentation",
                "我在求生，你在游戏",
                "2.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
