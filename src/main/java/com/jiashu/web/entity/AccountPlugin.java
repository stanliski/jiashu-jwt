package com.jiashu.web.entity;

import javax.persistence.*;

/**
 * Created on 2018/4/3 20:04.
 *
 * @author Stanley Huang
 */

@Entity
@Table(name = "account_plugin")
public class AccountPlugin {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, columnDefinition = "INT(10) UNSIGNED")
    private long id;
    @Column(name = "type")
    private int type;
    @Column(name = "userId")
    private long userId;
    @Column(name = "server")
    private String server;
    @Column(name = "port", unique = true)
    private int port;
    @Column(name = "password")
    private String password;
    @Column(name = "data")
    private String data;
    @Column(name = "status")
    private int status;
    @Column(name = "autoRemove")
    private int autoRemove;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAutoRemove() {
        return autoRemove;
    }

    public void setAutoRemove(int autoRemove) {
        this.autoRemove = autoRemove;
    }
}
