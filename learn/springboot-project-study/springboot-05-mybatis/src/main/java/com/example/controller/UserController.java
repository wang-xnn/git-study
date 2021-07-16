package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/userList")
    public List<User> userList(){
        List<User> users = userMapper.userList();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
    @RequestMapping("/addUser")
    public String addUser(){
        User user = new User(8, "胡", "junit");
        int res=userMapper.addUser(user);
        return "增加用户成功";
    }
    @RequestMapping("/updateUser")
    public String updateUser(){
        User user = new User(8, "胡柳", "1234567");
        int res=userMapper.updateUser(user);
        return "更新成功";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(){
        Integer id=8;
        int res=userMapper.deleteUser(id);
        return "已成功删除";
    }

}
