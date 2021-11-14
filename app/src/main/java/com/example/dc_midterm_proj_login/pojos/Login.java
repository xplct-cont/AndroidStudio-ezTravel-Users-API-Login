package com.example.dc_midterm_proj_login.pojos;

public class Login {
    private  String token, username, id, name, password;
    public Login(){}
    public Login(String token, String username, String id, String name, String password) {
        this.token = token;
        this.username = username;
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
