package com.wangxnn.mapper;

import com.wangxnn.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public User queryUserByName(String name);
    List<User>  userList();
    User getUserById(Integer id);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
}
