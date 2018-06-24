package com.johnxb.questionnaire.api;

import com.johnxb.questionnaire.dto.Auth.UserLoginInputDTO;
import com.johnxb.questionnaire.dto.Auth.UserSignUpInputDTO;
import com.johnxb.questionnaire.entity.AuthUser;
import com.johnxb.questionnaire.service.AuthUserService;
import com.johnxb.questionnaire.service.ClassificationService;
import com.johnxb.questionnaire.utils.BeanMapper;
import com.johnxb.questionnaire.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(description = "用户登录Api")
@RequestMapping("/User")
public class AuthController {
    private final AuthUserService authUserService;

    @Autowired
    public AuthController(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("sign_in")
    public JSONResult Sign_in(@Valid UserLoginInputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        AuthUser user = BeanMapper.map(input, AuthUser.class);
        jsonResult.setData(authUserService.signIn(user));
        return jsonResult;
    }

    @ApiOperation(value = "注册", notes = "注册", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("sign_up")
    public JSONResult Sign_up(@Valid UserSignUpInputDTO input) {
        JSONResult jsonResult = new JSONResult<>();
        AuthUser user = BeanMapper.map(input, AuthUser.class);
        if (authUserService.signUp(user)) {
            jsonResult.setMessage("注册成功");
        } else jsonResult.setMessage("注册失败，登录名已存在");
        return jsonResult;
    }
}
