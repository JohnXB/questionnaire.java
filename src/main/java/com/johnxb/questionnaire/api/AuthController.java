package com.johnxb.questionnaire.api;

import com.johnxb.questionnaire.dto.Auth.UserLoginDTO;
import com.johnxb.questionnaire.dto.Auth.UserLoginInputDTO;
import com.johnxb.questionnaire.dto.Auth.UserSignUpInputDTO;
import com.johnxb.questionnaire.dto.RequestDTO;
import com.johnxb.questionnaire.entity.AuthUser;
import com.johnxb.questionnaire.service.AuthUserService;
import com.johnxb.questionnaire.service.ClassificationService;
import com.johnxb.questionnaire.service.ICurrentUser;
import com.johnxb.questionnaire.utils.BeanMapper;
import com.johnxb.questionnaire.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@Api(description = "用户登录Api")
@RequestMapping("/User")
public class AuthController {
    private final AuthUserService authUserService;
    private final ICurrentUser currentUser;

    @Autowired
    public AuthController(AuthUserService authUserService, ICurrentUser currentUser) {
        this.authUserService = authUserService;
        this.currentUser = currentUser;
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("SignIn")
    public JSONResult Sign_in(@Valid @RequestBody UserLoginInputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        AuthUser user = BeanMapper.map(input, AuthUser.class);
        AuthUser currentUser = authUserService.signIn(user);
        if (currentUser == null) {
            UserLoginDTO userLoginDTO = new UserLoginDTO();
            userLoginDTO.setLogin(false);
            jsonResult.setData(userLoginDTO);
        } else {
            UserLoginDTO userLoginDTO = BeanMapper.map(currentUser, UserLoginDTO.class);
            userLoginDTO.setLogin(true);
            jsonResult.setData(userLoginDTO);
        }

        return jsonResult;
    }

    @ApiOperation(value = "注册", notes = "注册", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("SignUp")
    public JSONResult Sign_up(@Valid @RequestBody UserSignUpInputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        AuthUser user = BeanMapper.map(input, AuthUser.class);
        if (authUserService.signUp(user)) {
            jsonResult.setMessage("注册成功");
        } else jsonResult.setMessage("注册失败，登录名已存在");
        return jsonResult;
    }

    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("GetUser")
    public JSONResult Get_user(@Valid @RequestBody RequestDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        AuthUser user =currentUser.getUser(input.getToken());
        if (user == null) {
            UserLoginDTO userLoginDTO = new UserLoginDTO();
            userLoginDTO.setLogin(false);
            jsonResult.setData(userLoginDTO);
        } else {
            UserLoginDTO userLoginDTO = BeanMapper.map(user, UserLoginDTO.class);
            userLoginDTO.setLogin(true);
            jsonResult.setData(userLoginDTO);
        }
        return jsonResult;
    }
}
