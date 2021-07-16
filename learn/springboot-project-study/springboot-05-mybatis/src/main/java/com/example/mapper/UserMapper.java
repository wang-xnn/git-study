package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  //这个注解表示这是一个mybatis的mapper类
@Repository   //@Component
public interface UserMapper {
    List<User> userList();
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
}
