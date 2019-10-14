package com.example.community.model;

import java.io.Serializable;

public class Users implements Serializable {
    private String id;
    private String name;
    private String accountId;
    private String token;
    private String gmtcreate;
    private String gmtmodified;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private String bio;

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    private String avatarurl;

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

    public String getGmtcreate() {
        return gmtcreate;
    }

    public void setGmtcreate(String gmtcreate) {
        this.gmtcreate = gmtcreate;
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


}
