package com.app.forum.service;

import com.app.forum.DTO.UserDTO;
import com.app.forum.command.UserCommand;
import com.app.forum.model.User;
import com.app.forum.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username).stream().map(this::mapUserToDTO).findFirst();
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::mapUserToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> save(UserCommand userCommand) {
        User user = mapCommandToUser(userCommand);
        userRepository.save(user);
        return Optional.of(mapUserToDTO(user));
    }

    @Override
    public void delete(String username) {
        Optional<User> user = userRepository.findById(userRepository.findByUsernameIgnoreCase(username).get().getId());
        userRepository.deleteById(user.get().getId());
    }

    private UserDTO mapUserToDTO(final User user) {
        return new UserDTO(user.getUsername(), user.getPassword(), user.getEmail());
    }

    private User mapCommandToUser(final UserCommand userCommand) {
        return new User(userCommand.getUsername(), userCommand.getPassword(), userCommand.getEmail());
    }
}
