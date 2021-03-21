package com.app.forum.controller;

import com.app.forum.model.User;
import com.app.forum.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserController
{
    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping(path = {"/register"})
    public ResponseEntity<?> addUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/{id}")
    public void getUserById(@PathVariable int id)
    {
        userService.getUser(id);
    }

    @GetMapping(path = {"", "/"})
    public ResponseEntity<?> getUsers()
    {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user)
    {
        User updatedUser = userService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id)
    {
        userService.deleteUser(id);
        return ResponseEntity.ok("user deleted");
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody User user)
    {
        User getUser = userService.login(user);

        if (getUser != null)
            return ResponseEntity.ok("Login");
        else
            return ResponseEntity.ok("User not found");

    }
}
