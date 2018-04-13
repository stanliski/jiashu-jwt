package com.jiashu.web.entity.dto;


public class Proxy {

    private String name;

    private String host;

    private int port;

    private String password;

    private String method;

    private String comment;

    public Proxy(String name, String host, int port, String password, String method, String comment) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.password = password;
        this.method = method;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
