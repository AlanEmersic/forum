package com.app.forum.repository;

import com.app.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByUsernameIgnoreCase(String username);
    Optional<User> findOneByUsernameIgnoreCase(String username);
}
