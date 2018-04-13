package com.jiashu.web.controller;

import com.jiashu.web.auth.TokenValidator;
import com.jiashu.web.entity.ErrorInfo;
import com.jiashu.web.entity.User;
import com.jiashu.web.service.UserDetailService;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.jiashu.web.entity.dto.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018/4/3 20:04.
 *
 * @author Stanley Huang
 */
@RestController
@Validated
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private TokenValidator tokenValidator;

    @ApiOperation("获取用户本人信息")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response<User>> me(@RequestHeader("Authorization")
                                             @Length(max = 2000) String token) {
        long userId = tokenValidator.getUserIdWithoutValidated(token);
        User me = null;
        if (userId > 0) {
            me = userDetailService.me(userId);
        }
        Response<User> response = me != null ? new Response<>(me)
                : new Response<>(ErrorInfo.NOT_FOUND, "No such user! ", "该用户不存在");
        return new ResponseEntity<>(response, response.getStatusCode());
    }

    @GetMapping("/userList")
    public Map<String, Object> userList() {
//        List<User> users = userRepository.findAll();
        Map<String, Object> map = new HashMap<>();
//        map.put("users", users);
        return map;
    }


}
