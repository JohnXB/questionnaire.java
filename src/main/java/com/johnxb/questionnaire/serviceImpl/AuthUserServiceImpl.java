package com.johnxb.questionnaire.serviceImpl;


import com.johnxb.questionnaire.dao.AuthUserMapper;
import com.johnxb.questionnaire.dao.UserRolesMapper;
import com.johnxb.questionnaire.entity.AuthUser;
import com.johnxb.questionnaire.service.AuthUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class AuthUserServiceImpl implements AuthUserService {
    private final AuthUserMapper authUserMapper;
    private final UserRolesMapper userRolesMapper;

    @Autowired
    public AuthUserServiceImpl(AuthUserMapper authUserMapper, UserRolesMapper userRolesMapper) {
        this.authUserMapper = authUserMapper;
        this.userRolesMapper = userRolesMapper;
    }

    @Override
    public AuthUser findByUserName(String username) {
        AuthUser authUser = this.authUserMapper.selectByUsername(username);
        authUser.setRoles(userRolesMapper.getRolesByUserId(authUser.getId()));
        return authUser;
    }

    @Override
    public boolean signUp(AuthUser user) {
        List<String> usernameList = authUserMapper.checkByUsername(user.getUsername());
        if (usernameList.size() > 0) {
            return false;
        }
        user.setAvatar("aaa");
//        加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword().trim()));
        user.setCurrentToken(generateToken(user));
        int id = authUserMapper.insert(user);
        userRolesMapper.insertUserRole(user.getId(), 2);
        return id > 0;

    }

    public String signIn(AuthUser user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pass = user.getPassword();

        user = authUserMapper.selectBySignIn(user);
        if (user == null) {
            return null;
        }
        if (encoder.matches(pass, user.getPassword())) {
            return generateToken(user);
        }
        return null;
    }

    String generateToken(AuthUser user) {
        return Jwts.builder()
                .claim("id", user.getId())   //设置payload的键值对
                .claim("username", user.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secret") //采用什么算法是可以自己选择的，不一定非要采用HS512
                .compact();
    }

}
