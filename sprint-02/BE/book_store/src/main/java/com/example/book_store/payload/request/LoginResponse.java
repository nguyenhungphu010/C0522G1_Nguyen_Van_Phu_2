package com.example.book_store.payload.request;

import java.util.List;

public class LoginResponse {
    private String accessToken;
    private String username;
    private Integer id;
    private List<String> roles;
    private String isLogin;

    public LoginResponse() {
    }

    public LoginResponse(String accessToken, String username, Integer id, List<String> roles, String isLogin) {
        this.accessToken = accessToken;
        this.username = username;
        this.id = id;
        this.roles = roles;
        this.isLogin = isLogin;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }
}
