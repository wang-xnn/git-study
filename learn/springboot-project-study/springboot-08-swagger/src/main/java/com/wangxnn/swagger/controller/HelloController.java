package com.wangxnn.swagger.controller;

import com.wangxnn.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@ApiOperation("helloController")//Operation接口
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
    // 只要我们的接口中，返回值存在实体类,就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }
    @ApiOperation("程序员的接口")
    @PostMapping("/wang")
    @ResponseBody
    public String wang(@ApiParam("这个名字会被返回")String username){
        return username;
    }

}
