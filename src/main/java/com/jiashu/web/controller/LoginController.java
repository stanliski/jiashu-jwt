package com.jiashu.web.controller;

import com.jiashu.web.auth.TokenGenerator;
import com.jiashu.web.entity.ErrorInfo;
import com.jiashu.web.entity.User;
import com.jiashu.web.entity.dto.*;
import com.jiashu.web.service.UserDetailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2018/4/3 20:04.
 *
 * @author Stanley Huang
 */

@RestController
@Validated
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private TokenGenerator tokenGenerator;

    private static final int RETRY_NUM = 3;

    @ApiOperation("用户登录")
    @ApiResponses(@ApiResponse(code = 200, message = "Token and login user info"))
    @PostMapping("/login")
    public ResponseEntity<Response<LoginInfo>> login(@RequestBody LoginRequest loginRequest) {
        logger.debug("Login user is coming with: {}", loginRequest);
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        User user = userDetailService.loadUserByEmail(email);
        String encodePassword = DigestUtils.md5DigestAsHex((password + email).getBytes());
        if (null == user || !user.getPassword().equals(encodePassword)) {
            Response<LoginInfo> notFoundResponse = new Response<>(ErrorInfo.NOT_FOUND, "No such user! ", "用户名或密码错误");
            return new ResponseEntity<>(notFoundResponse, notFoundResponse.getStatusCode());
        }
        String token = tokenGenerator.generateToken(user.getId(), user.getEmail());
        Response<LoginInfo> response = new Response<>(new LoginInfo(token, user));
        return new ResponseEntity<>(response, response.getStatusCode());
    }


    @ApiOperation("用户注册接口")
    @ApiResponses(@ApiResponse(code = 200, message = "Token and register user info"))
    @PostMapping("/signup")
    public ResponseEntity<Response<SignupInfo>> signup(@RequestBody SignupRequest signupRequest) {
        SignupInfo result = userDetailService.addUser(signupRequest);
        Response<SignupInfo> response = new Response<>(result);
        return new ResponseEntity<>(response, response.getStatusCode());
    }


//    @ApiOperation("用户注册")
//    @PostMapping("/signup1")
//    public ResponseEntity<Response<SignupInfo>> signup1(@RequestBody SignupRequest signupRequest) {
//        logger.debug("New user is coming with: {}", signupRequest);
//        String email = signupRequest.getEmail();
//        String password = signupRequest.getPassword();
//        User user = userDetailService.loadUserByEmail(email);
//        if (user != null) {
//            Response<SignupInfo> notFoundResponse = new Response<>(ErrorInfo.NOT_FOUND, "User exist! ", "用户名已存在");
//            return new ResponseEntity<>(notFoundResponse, notFoundResponse.getStatusCode());
//        }
////        userDetailService.addUser(email, password);
//        Setting setting = settingService.loadAccountSetting();
//        String settingStr = setting.getValue();
//        try {
//            Map<String, Object> settingMap = JsonUtil.strJson2Map(settingStr);
//            Map<String, Object> portSetting = (Map<String, Object>) settingMap.get("port");
//            Boolean isPortRandom = (Boolean) portSetting.get("random");
//            Integer portStart = (Integer) portSetting.get("start");
//            Integer portEnd = (Integer) portSetting.get("end");
//            int myPort = -1;
//            if (isPortRandom) {
//                myPort = generatePort(portStart, portEnd);
//            } else {
//                myPort = accountPluginService.getMaxPort(portStart, portEnd);
//                myPort = myPort + 1;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private int generatePort(int portStart, int portEnd) {
//        int myPort = getRandomPort(portStart, portEnd);
//        boolean isExist = accountPluginService.checkIfPortExists(myPort);
//        int retry = 0;
//        if (isExist) {
//            for (int i = 0; i < RETRY_NUM; i++) {
//                retry++;
//                myPort = getRandomPort(portStart, portEnd);
//                isExist = accountPluginService.checkIfPortExists(myPort);
//                if (!isExist) {
//                    break;
//                }
//            }
//        }
//        if (retry == RETRY_NUM) {
//            return -1;
//        }
//        return myPort;
//    }
//
//    private int getRandomPort(int start, int end) {
//        int randomPort = (int) (Math.random() * (end - start + 1) + start);
//        return randomPort;
//    }
}
