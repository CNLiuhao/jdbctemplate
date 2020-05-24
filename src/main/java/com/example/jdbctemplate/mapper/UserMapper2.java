package com.example.jdbctemplate.mapper;

import com.example.jdbctemplate.Beans.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper2 {
    @Select("select * from user")
    List<UserBean> getAllUsers();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "u"),
            @Result(property = "address", column = "a")
    })
    @Select("select username as u,address as a,id as id from user where id=#{id}")
    UserBean getUserById(Long id);

    @Select("select * from user where username like concat('%',#{name},'%')")
    List<UserBean> getUsersByName(String name);

    @Insert({"insert into user(username,address) values(#{username},#{address})"})
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    Integer addUser(UserBean user);

    @Update("update user set username=#{username},address=#{address} where id=#{id}")
Integer updateUserById(UserBean user);

    @Delete("delete from user where id=#{id}")
    Integer deleteUserById(Integer id);
}
