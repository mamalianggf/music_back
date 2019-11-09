package com.gf.music.domain;

import java.io.Serializable;

public class User implements Serializable{

    private int id;
    private String name;
    private String pwd;
    private int account;
    private String img;
    private String email;

    public User() {
    }

    public User(int id, String name, String pwd, int account, String img, String email) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.account = account;
        this.img = img;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", account=" + account +
                ", img='" + img + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
