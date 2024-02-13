package com.notes.service.impl;

import com.notes.exception.ResourceNotFoundException;
import com.notes.model.User;
import com.notes.repository.UserRepository;
import com.notes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User create(final User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean existsByUsername(final String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public User findBy(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User with username[%s] not found.".formatted(username)));
    }

}