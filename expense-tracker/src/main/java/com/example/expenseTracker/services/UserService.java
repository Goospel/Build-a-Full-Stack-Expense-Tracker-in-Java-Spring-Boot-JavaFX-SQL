package com.example.expenseTracker.services;

import com.example.expenseTracker.entities.User;
import com.example.expenseTracker.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> getUserById(int userId) {
        log.info("Getting the user by id: {}", userId);
        return userRepository.findById(userId);
    }
}
