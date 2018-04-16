package com.jiashu.web.entity.dto;

public class SignupInfo {

    private boolean success;

    public SignupInfo() {}

    public SignupInfo(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
