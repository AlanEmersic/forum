package com.app.forum.service;

import com.app.forum.DTO.UserDTO;
import com.app.forum.command.UserCommand;

import java.util.List;
import java.util.Optional;

public interface UserService
{
    Optional<UserDTO> findByUsername(String username);

    List<UserDTO> findAll();

    Optional<UserDTO> save(UserCommand userCommand);

    void delete(String username);
}
