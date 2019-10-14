package com.example.community.dto;

import com.example.community.model.Users;


public class QuestionDTO {
    private int id;
    private String title;
    private String description;
    private String gmtcreate;
    private String gmtmodified;
    private String creator;
    private int commentcount;
    private int viewcount;
    private int likecount;
    private String tag;
    private Users users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
