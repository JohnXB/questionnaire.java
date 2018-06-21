package com.johnxb.questionnaire.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "用户请求")
@RequestMapping("/User")
public class UserController {

//    private final UserMapper userMapper;
//    @Autowired
//    public UserController(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }
//    @ApiOperation("用户注册")
//    @RequestMapping(value = "/sign_up" ,method = RequestMethod.GET)
//    public User insertUser() {
//        User user = new User(null, "inke");
//        userMapper.insert(user);
//        return user;
//    }
}