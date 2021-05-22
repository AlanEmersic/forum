package com.app.forum.DTO;

import java.util.Set;

public class UserDTO {

    private String username;
    private String password;
    private String email;
    private Set<String> authorities;

    public UserDTO(String username, String password, String email, Set<String> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }
}
