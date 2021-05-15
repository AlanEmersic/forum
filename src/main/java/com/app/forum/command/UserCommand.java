package com.app.forum.command;

import javax.validation.constraints.NotBlank;

public class UserCommand
{
    @NotBlank(message = "username must not be empty")
    private String username;
    @NotBlank(message = "password must not be empty")
    private String password;
    @NotBlank(message = "email must not be empty")
    private String email;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
