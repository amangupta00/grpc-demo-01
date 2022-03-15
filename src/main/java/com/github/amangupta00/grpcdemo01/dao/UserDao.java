package com.github.amangupta00.grpcdemo01.dao;


import com.github.amangupta00.grpcdemo01.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserDao {
    @Select("select * from user")
    public List<User> getAllUsers();

    @Select("select * from user where username = #{username}")
    public User getUserForUserId(String username);

    @Insert("insert into Users(id,username,password,name,gender,age) values (#{id},#{username},#{password},#{name},#{gender},#{age})")
    public User insert(User user);

    @Delete("delete from Users where id=#{id}")
    public int deleteById(int id);
}