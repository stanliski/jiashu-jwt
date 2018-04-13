package com.jiashu.web.entity.dto;

/**
 * Created on 2017/12/18.
 *
 * @author Jenrry You
 */
public class Token {
    private String exp;
    private long id;
    private String address;
    private String nonce;

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }
}