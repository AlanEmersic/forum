package com.app.forum.service;

import com.app.forum.repository.UserRepository;
import com.app.forum.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    //    Post
    public User addUser(User user)
    {
        return userRepository.save(user);
    }

    //    Get
    public User getUser(int id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    //    Delete
    public void deleteUser(int id)
    {
        userRepository.deleteById(id);
    }

    //    Update
    public User updateUser(User user)
    {
        User currentUser = userRepository.findById(user.getId()).orElse(null);

        if (currentUser != null)
        {
            currentUser.setUsername(user.getUsername());
            currentUser.setPassword(user.getPassword());
            currentUser.setEmail(user.getEmail());
            return userRepository.save(currentUser);
        }

        return null;
    }

    //    Login
    public User login(User user)
    {
        Optional<User> checkUser = userRepository.findByUsername(user.getUsername());

        if (checkUser.isPresent() && user.getPassword().equals(checkUser.get().getPassword()))
        {
            return checkUser.get();
        }

        return null;
    }
}
