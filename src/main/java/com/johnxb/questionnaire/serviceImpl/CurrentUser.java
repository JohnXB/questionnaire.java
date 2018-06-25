package com.johnxb.questionnaire.serviceImpl;

import com.johnxb.questionnaire.entity.AuthUser;
import com.johnxb.questionnaire.service.AuthUserService;
import com.johnxb.questionnaire.service.ICurrentUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrentUser implements ICurrentUser{
    private final AuthUserService authUserService;

    @Autowired
    public CurrentUser(AuthUserService authUserService) {
        this.authUserService = authUserService;
    }

    public AuthUser getUser(String token) {

        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey("secret")
                    .parseClaimsJws(token)
                    .getBody();
            AuthUser authUser = authUserService.findByUserName((String) claims.get("username"));
            return authUser;
        } catch (Exception e) {
            return null;
        }

    }
    public boolean isAdmin(String token){
        AuthUser user = this.getUser(token);
        if(user == null){
            return false;
        }
        List<String> roles = user.getRoles();
        boolean isAdmin = false;
        for (String role:roles ) {
            if(role.equals("ROLE_ADMIN") )
                isAdmin=true;
        }
        return isAdmin;
    }
    public boolean isUser(String token){
        AuthUser user = this.getUser(token);
        if(user == null){
            return false;
        }
        List<String> roles = user.getRoles();
        boolean isUser = false;
        for (String role:roles ) {
            if(role.equals("ROLE_USER"))
                isUser=true;
        }
        return isUser;
    }
    public int getUserId(String token){
        AuthUser user = this.getUser(token);
        return user.getId();
    }
}
