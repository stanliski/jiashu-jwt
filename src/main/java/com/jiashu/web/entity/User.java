package com.jiashu.web.entity;

import javax.persistence.*;


/**
 * Created on 2018/4/4 12:36.
 *
 * @author Stanley Huang
 */

@Entity
@Table(name = "user")
public class User {

    @GeneratedValue
    @Id
    @Column(name = "Id", nullable = false, columnDefinition = "INT(10) UNSIGNED")
    private long id;
    @Column(name = "username", unique = true)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "telegram")
    private String telegram;
    @Column(name = "type")
    private String type;
    @Column(name = "createTime", columnDefinition = "default 0")
    private long createTime;
    @Column(name = "lastLogin", columnDefinition = "default 0")
    private long lastLogin;
    @Column(name = "resetPasswordId")
    private String resetPasswordId;
    @Column(name = "resetPasswordTime", columnDefinition = "default 0")
    private long resetPasswordTime;

    public User() {}

    public User(String username, String password, String email, String type) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelegram() {
        return telegram;
    }

    public void setTelegram(String telegram) {
        this.telegram = telegram;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(long lastLogin) {
        this.lastLogin = lastLogin;
    }

    public long getResetPasswordTime() {
        return resetPasswordTime;
    }

    public void setResetPasswordTime(long resetPasswordTime) {
        this.resetPasswordTime = resetPasswordTime;
    }

    public String getResetPasswordId() {
        return resetPasswordId;
    }

    public void setResetPasswordId(String resetPasswordId) {
        this.resetPasswordId = resetPasswordId;
    }
}
