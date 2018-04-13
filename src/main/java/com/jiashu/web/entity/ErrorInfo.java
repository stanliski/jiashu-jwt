package com.jiashu.web.entity;

import org.springframework.http.HttpStatus;

/**
 * Created on 2017/12/18.
 * 0-999:  General errors
 * 1000-1100: UnisdkLoginInfo & register  errors;
 * 1101-1200: sale  errors;
 *
 * @author Jenrry You
 */
public enum ErrorInfo {
    INVAID_REQUEST(1, HttpStatus.BAD_REQUEST, "Bad data in request"),
    EXPIRED_TOKEN(2, HttpStatus.UNAUTHORIZED, "General: expired token"),
    INVALID_TOKEN(3, HttpStatus.UNAUTHORIZED, "General: invalid token"),
    NOT_FOUND(4, HttpStatus.NOT_FOUND, "Data not found"),

    LOGIN_UNREGISTERED(1000, HttpStatus.OK, "UnisdkLoginInfo: need register"),
    GAS3_ERROR(1000, HttpStatus.INTERNAL_SERVER_ERROR, "GAS3: Invalid response"),
    REGISTER_DUPLICATED(1001, HttpStatus.OK, "Register: duplicated registration"),

    SELL_OUT(1101, HttpStatus.OK, "Sale: sell out"),
    NO_ENOUGH_YUANBAO(1102, HttpStatus.OK, "Sale: insufficient money");


    private int errcode;
    private HttpStatus statusCode;
    private String defaultMessage;


    private ErrorInfo(int errorCode, HttpStatus statusCode, String defaultMessage) {
        this.errcode = errorCode;
        this.statusCode = statusCode;
        this.defaultMessage = defaultMessage;
    }

    private ErrorInfo(int errcode, String message, HttpStatus statusCode) {
        this.errcode = errcode;
        this.defaultMessage = message;
        this.statusCode = statusCode;
    }

    public int getErrcode() {
        return errcode;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }


}
