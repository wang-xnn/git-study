package com.wangxnn.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Security;

@Controller
public class MyController {
    @RequestMapping({"/","/index","index.html"})
    public String toIndex(Model model){
        model.addAttribute("message","hello,shiro");
        return "index";
    }
    @RequestMapping("/user/add.html")
    public String toAdd(){
        return "/user/add.html";
    }
    @RequestMapping("/user/update.html")
    public String toUpdate(){
        return "/user/update.html";
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "toLogin";
    }
    @RequestMapping("/login")
    public String login(String username, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("message","没有这个用户");
            return "toLogin";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("message","密码错误");
            return "toLogin";
        }
    }
    @RequestMapping("/authorize")
    @ResponseBody
    public String unautho(){
        return "你并没有这个权限";
    }
}
