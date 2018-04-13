package com.jiashu.web.service;

import com.jiashu.web.entity.User;

/**
 * Created on 2018/4/9 10:43.
 *
 * @author Stanley Huang
 */
public interface UserDetailService {

    User me(long id);

    User loadUserByEmail(String email);

    void addUser(String email, String password);
}
