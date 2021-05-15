package com.app.forum.service;

import com.app.forum.DTO.PostDTO;;
import com.app.forum.command.PostCommand;
import com.app.forum.model.Post;
import com.app.forum.model.User;
import com.app.forum.repository.PostRepository;
import com.app.forum.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<PostDTO> findAllByUsername(String username) {
        return postRepository.findAllByUserid_UsernameIgnoreCase(username).stream().map(this::mapPostToDTO).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> findAll() {
        return postRepository.findAll().stream().map(this::mapPostToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PostDTO> save(PostCommand postCommand, String username) {
        Post post = mapCommandToPost(postCommand);
        Optional<User> user = userRepository.findByUsernameIgnoreCase(username);
        post.setUserid(user.get());
        postRepository.save(post);
        return Optional.of(mapPostToDTO(post));
    }

    private Post mapCommandToPost(final PostCommand postCommand) {
        return new Post(postCommand.getComment(), postCommand.getTimestamp());
    }

    private PostDTO mapPostToDTO(final Post post) {
        return new PostDTO(post.getComment(), post.getTimestamp());
    }

    private Timestamp parseTimestamp(String timestamp) {
        try {
            return new Timestamp(new SimpleDateFormat("dd.MM.yyyy. HH:mm:ss").parse(timestamp).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
