package com.jiashu.web.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiashu.web.entity.ErrorInfo;
import org.springframework.http.HttpStatus;

/**
 * Created on 2017/12/18.
 *
 * @author Jenrry You
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private boolean success;
    private T data;
    private Integer errcode;
    private String message;
    private String tip;
    @JsonIgnore
    private HttpStatus statusCode;

    public Response(ErrorInfo errorInfo) {
        this.success = false;
        errcode = errorInfo.getErrcode();
        message = errorInfo.getDefaultMessage();
        statusCode = errorInfo.getStatusCode();
    }

    public Response(ErrorInfo errorInfo, String message) {
        this.success = false;
        errcode = errorInfo.getErrcode();
        statusCode = errorInfo.getStatusCode();
        this.message = message;

    }

    public Response(ErrorInfo errorInfo, String message, String tip) {
        this.success = false;
        errcode = errorInfo.getErrcode();
        statusCode = errorInfo.getStatusCode();
        this.message = message;
        this.tip = tip;

    }

    public Response(T data) {
        success = true;
        this.data = data;
        this.statusCode = HttpStatus.OK;
    }


    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public String getMessage() {
        return message;
    }

    public String getTip() {
        return tip;
    }
}
