package com.app.forum.repository;

import com.app.forum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByUserid_UsernameIgnoreCase(String username);
}
