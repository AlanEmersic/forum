package com.app.forum.controller;

import com.app.forum.DTO.UserDTO;
import com.app.forum.command.UserCommand;
import com.app.forum.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController
{
    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable final String username) {
        return userService.findByUsername(username).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@Valid @RequestBody final UserCommand userCommand) {
        return userService.save(userCommand)
                .map(userDTO -> ResponseEntity.status(HttpStatus.CREATED).body(userDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{username}")
    public void delete(@PathVariable String username){
        userService.delete(username);
    }
}
