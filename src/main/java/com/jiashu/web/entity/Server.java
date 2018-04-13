package com.jiashu.web.entity;

import javax.persistence.*;

/**
 * Created on 2018/4/4 12:36.
 *
 * @author Stanley Huang
 */

@Entity
@Table(name = "server")
public class Server {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false, columnDefinition = "INT(10) UNSIGNED")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "host")
    private String host;
    @Column(name = "port")
    private int port;
    @Column(name = "password")
    private String password;
    @Column(name = "scale", columnDefinition = "Decimal(8,2) default '1.00'")
    private float scale;
    @Column(name = "method", columnDefinition = "varchar(255) default 'aes-256-cfb'")
    private String method;
    @Column(name = "comment")
    private String comment;
    @Column(name = "shift")
    private int shift;

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

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }
}
