package com.wangxnn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/userlist")
    public List<Map<String,Object>> getUserList(){
        String sql="select * from user";
        List<Map<String,Object>> user_list=jdbcTemplate.queryForList(sql);
        return user_list;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql="insert mybatis.user(id,name,pwd) values (7,'杨风','123456')";
       jdbcTemplate.update(sql);
        return "添加成功";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql="update mybatis.user set name=?,pwd=? where id="+id;
        Object[] objects = new Object[2];
        objects[0]="杨间";
        objects[1]="aaa111aaa";
        jdbcTemplate.update(sql,objects);
        return "Update User OK";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql="delete from user where id=?";
        jdbcTemplate.update(sql,id);
        return "成功删除";
    }

}
