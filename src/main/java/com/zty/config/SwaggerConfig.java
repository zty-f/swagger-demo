/**
 * @program: swagger-demo
 * @ClassName: SwaggerConfig
 * @description:
 * @author: zty
 * @create: 2021-07-23 10:24
 **/
package com.zty.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2   //开启Swagger2
public class SwaggerConfig {

    @Bean
    public  Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A");
    }
    @Bean
    public  Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("B");
    }
    @Bean
    public  Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("C");
    }

    //配置swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        // 设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        // 获取项目的环境： 通过environment.acceptsProfiles判断是否存在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("张天泳")
                .enable(flag) // 是否启动swagger
                .select()
                // RequestHandlerSelectors  配置要扫描的接口的方式
                // basePackage :指定要扫描的包
                // any:扫描全部
                // none:都不扫描
                // withClassAnnotation:扫描类上的注解，参数是一个注解方反射对象
                // withMethodAnnotation：扫描方法上面的注解
                .apis(RequestHandlerSelectors.basePackage("com.zty"))
                // paths() 过滤什么路径
                //.paths(PathSelectors.ant("/zty/**"))
                .build();
    }

    // 配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
        Contact contact=new Contact("张天泳","http://www.baidu.com","2559247260@qq.com");
        return new ApiInfo("ZTY's Swagger API文档",
                "描述信息",
                "1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
