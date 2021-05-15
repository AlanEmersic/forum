package com.app.forum.controller;

import com.app.forum.DTO.PostDTO;
import com.app.forum.command.PostCommand;
import com.app.forum.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{username}")
    public List<PostDTO> getAllPostsByUsername(@PathVariable final String username) {
        return postService.findAllByUsername(username);
    }

    @PostMapping()
    public ResponseEntity<PostDTO> save(@Valid @RequestBody final PostCommand postCommand, @RequestParam String username) {
        return postService.save(postCommand, username)
                .map(postDTO -> ResponseEntity.status(HttpStatus.CREATED).body(postDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }
}
