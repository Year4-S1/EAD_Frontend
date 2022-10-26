package com.telna.models;

public class User {
    private IdDetails id;
    private String userId;
    private String name;
    private String phone;
    private String password;
    private String userType;
    private Boolean loginStatus;

    public User(IdDetails id, String userId, String name, String phone, String password, String userType, Boolean loginStatus) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.userType = userType;
        this.loginStatus = loginStatus;
    }

    public IdDetails getId() {
        return id;
    }

    public void setId(IdDetails id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
