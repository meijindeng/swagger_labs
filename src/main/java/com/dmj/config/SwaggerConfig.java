package com.dmj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

@Configuration//配置到spring boot中
@EnableSwagger2//开启swagger2
public class SwaggerConfig {

    //Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        /**
         * 希望我的Swagger在生产环境中使用，发布的时候不使用？
         * 1、判断是不是生产环境 flag=false
         * 2、注入enable(flag)
         */
        //第一步：配置开发(8081)和发布(8082)环境,配置环境中选择开启一个环境，注意端口号
        //第一步：获取项目环境(Environment environment)
        //第二步：设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //第三步：通过environment.acceptsProfiles判断是否在环境中
        boolean flag = environment.acceptsProfiles(profiles);
        //第四步：enable(flag) 使用监听


        return new Docket(DocumentationType.SWAGGER_2)
                //信息1：swagger信息(apiInfo)
                .apiInfo(apiInfo())
                //信息4：配置API文档分组
                .groupName("meijindeng")
                .enable(flag)   //是否启用swagger，默认为true
                //信息2：扫描接口(select\apis\paths\build)。
                /*
                   RequestHandlerSelectors：配置要扫描接口的方式。
                   basePackage()：指定要扫描的包(常用)
                   any()：扫描全部
                   none()：都不扫描
                   withClassAnnotation()：扫描类上的注解
                   withMethodAnnotation()：扫描方法上的注解
                 */
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dmj.controller"))
                //.paths(PathSelectors.ant("/dmj/**"))  //paths()：过滤什么路径,用了就扫描不到dmj下的东西
                .build();
    }

    //配置多个分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("B");
    }

    //配置Swagger信息1：apiInfo
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("meijindeng", "https://github.com/meijindeng", "meijindeng@126.com");

        return new ApiInfo("meijindeng的SwaggerAPI文档",
                "人生短短几个秋",
                "1.0",
                "https://github.com/meijindeng",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
