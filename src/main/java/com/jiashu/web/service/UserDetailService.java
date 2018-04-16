package com.jiashu.web.service;

import com.jiashu.web.entity.User;
import com.jiashu.web.entity.dto.SignupInfo;
import com.jiashu.web.entity.dto.SignupRequest;

/**
 * Created on 2018/4/9 10:43.
 *
 * @author Stanley Huang
 */
public interface UserDetailService {

    User me(long id);

    User loadUserByEmail(String email);

    SignupInfo addUser(SignupRequest signup);
}
