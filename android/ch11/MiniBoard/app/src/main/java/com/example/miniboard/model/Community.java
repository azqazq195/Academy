package com.example.miniboard.model;

import java.io.Serializable;

public class Community implements Serializable {
    public static String rt;
    public static int total;

    private String reg_date;
    private String user_name;
    private String subject;
    private String user_pwd;
    private String edit_date;
    private int seq;
    private String email;
    private String content;

    public static String getRt() {
        return rt;
    }

    public static void setRt(String rt) {
        Community.rt = rt;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Community.total = total;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getEdit_date() {
        return edit_date;
    }

    public void setEdit_date(String edit_date) {
        this.edit_date = edit_date;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
