package com.app.forum.service;

import com.app.forum.DTO.UserDTO;
import com.app.forum.command.UserCommand;
import com.app.forum.model.Authority;
import com.app.forum.model.User;
import com.app.forum.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findOneByUsernameIgnoreCase(username).map(this::mapUserToDTO);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::mapUserToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> save(UserCommand userCommand) {
        User user = mapCommandToUser(userCommand);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Authority> authorities = new HashSet<>(userRepository.findOneByUsernameIgnoreCase("user").get().getAuthorities());
        user.setAuthorities(authorities);

        userRepository.save(user);
        return Optional.of(mapUserToDTO(user));
    }

    @Override
    public void delete(String username) {
        Optional<User> user = userRepository.findById(userRepository.findByUsernameIgnoreCase(username).get().getId());
        userRepository.deleteById(user.get().getId());
    }

    private UserDTO mapUserToDTO(final User user) {
        return new UserDTO(user.getUsername(), user.getPassword(), user.getEmail(),
                user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet()));
    }

    private User mapCommandToUser(final UserCommand userCommand) {
        return new User(userCommand.getUsername(), userCommand.getPassword(), userCommand.getEmail());
    }
}
