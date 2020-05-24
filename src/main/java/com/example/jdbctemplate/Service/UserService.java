package com.example.jdbctemplate.Service;

import com.example.jdbctemplate.Beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    //增
    public int addUser(UserBean user) {
        return jdbcTemplate.update("insert into user (username,address) values (?,?);", user.getUsername(), user.getAddress());
    }
}
