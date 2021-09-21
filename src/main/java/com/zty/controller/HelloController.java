/**
 * @program: swagger-demo
 * @ClassName: HelloController
 * @description:
 * @author: zty
 * @create: 2021-07-23 10:20
 **/
package com.zty.controller;

import com.zty.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Hello 控制类")
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){ 
        return "Hello World!";
    }

    // 只要我们的接口中，返回值存在实体类，他就会被扫描到swagger中
    @PostMapping("/user")
    public User user(){
        return new User();
    }

    //Operation接口，不是放在类上面，是方法
    @ApiOperation("Hello 控制方法")
    @GetMapping(value = "/hello2")
    public  String  hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    //Operation接口，不是放在类上面，是方法
    @ApiOperation("Post测试")
    @PostMapping(value = "/hello2")
    public  User  postt(@ApiParam("用户名") User user){
        return user;
    }
}
