package com.jiashu.web.entity.dto;

import com.jiashu.web.entity.User;

public class LoginInfo {

    private String accessKey;

    private User userDetail;

    public LoginInfo(String accessKey, User user) {
        this.accessKey = accessKey;
        this.userDetail = user;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public User getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(User userDetail) {
        this.userDetail = userDetail;
    }
}
