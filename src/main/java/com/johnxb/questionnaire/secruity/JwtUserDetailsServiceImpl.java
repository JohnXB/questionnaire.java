package com.johnxb.questionnaire.secruity;

import com.johnxb.questionnaire.dao.AuthUserMapper;
import com.johnxb.questionnaire.entity.AuthUser;
import com.johnxb.questionnaire.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AuthUserService authUserService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        AuthUser user = authUserService.findByUserId(Integer.parseInt(id));

        if (user == null) {
            throw new UsernameNotFoundException(String.format("该用户不存在" ));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}