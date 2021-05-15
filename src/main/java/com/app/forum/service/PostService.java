package com.app.forum.service;

import com.app.forum.DTO.PostDTO;
import com.app.forum.command.PostCommand;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<PostDTO> findAllByUsername(String username);

    List<PostDTO> findAll();

    Optional<PostDTO> save(PostCommand postCommand, String username);
}
