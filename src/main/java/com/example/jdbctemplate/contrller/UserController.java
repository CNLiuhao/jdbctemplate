package com.example.jdbctemplate.contrller;

import com.example.jdbctemplate.Beans.UserBean;
import com.example.jdbctemplate.Service.UserService;
import com.example.jdbctemplate.mapper.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Resource
    UserMapper2 userMapper2;
    @GetMapping(value = "add/{name}/{address}")
    @ResponseBody
    public int adduser(@PathVariable("name") String name,@PathVariable("address") String address){
        UserBean userBean = new UserBean();
        userBean.setUsername(name);
        userBean.setAddress(address);
        return userService.addUser(userBean);
    }
    @GetMapping(value = "select")
    @ResponseBody
    public List<UserBean> Userlist(){
    return userMapper2.getAllUsers();
    }

    @GetMapping(value = "selectbyid/{id}")
    @ResponseBody
    public UserBean User(@PathVariable("id") String id){
        Long Id  = Long.parseLong(id);
        return userMapper2.getUserById(Id);

    }
}
