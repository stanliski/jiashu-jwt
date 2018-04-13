package com.jiashu.web.service.impl;

import com.jiashu.web.entity.User;
import com.jiashu.web.repository.UserRepository;
import com.jiashu.web.service.UserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * Created on 2018/4/9 10:49.
 *
 * @author Stanley Huang
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User me(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public void addUser(String email, String password) {
        // fixme
        String type = "normal";
        String encodePassword = DigestUtils.md5DigestAsHex((password + email).getBytes());
        User user = new User(email, email, encodePassword, type);
        userRepository.save(user);
    }


}
