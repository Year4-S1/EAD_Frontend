package com.telna.models;

public class User {
    private String Id;
    private String Name;
    private String Phone;
    private String Password;
    private String UserType;
    private Boolean LoginStatus;

    public User(String id, String name, String phone, String password, String userType, Boolean loginStatus) {
        Id = id;
        Name = name;
        Phone = phone;
        Password = password;
        UserType = userType;
        LoginStatus = loginStatus;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public Boolean getLoginStatus() {
        return LoginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        LoginStatus = loginStatus;
    }
}
