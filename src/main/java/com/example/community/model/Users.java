package com.example.community.model;

import java.io.Serializable;

public class Users implements Serializable {
    private String id;
    private String name;
    private String accountId;
    private String token;
    private String gmtCreate;
    private String gmtmodified;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtmodified() {
        return gmtmodified;
    }

    public void setGmtmodified(String gmtmodified) {
        this.gmtmodified = gmtmodified;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", accountId='" + accountId + '\'' +
                ", token='" + token + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtmodified='" + gmtmodified + '\'' +
                '}';
    }
}
