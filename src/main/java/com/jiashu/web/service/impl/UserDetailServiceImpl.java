package com.jiashu.web.service.impl;

import com.jiashu.web.auth.constant.Constants;
import com.jiashu.web.entity.User;
import com.jiashu.web.entity.dto.SignupInfo;
import com.jiashu.web.entity.dto.SignupRequest;
import com.jiashu.web.repository.UserRepository;
import com.jiashu.web.service.UserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public SignupInfo addUser(SignupRequest signup) {
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SignupRequest> entity = new HttpEntity<>(signup, headers);
        ResponseEntity<SignupInfo> response = restTemplate.postForEntity(Constants.SHADOWSOCKS_MANAGER_API + "/home/mobileSignup", entity, SignupInfo.class);
        SignupInfo result = response.getBody();
        return result;
    }


}
