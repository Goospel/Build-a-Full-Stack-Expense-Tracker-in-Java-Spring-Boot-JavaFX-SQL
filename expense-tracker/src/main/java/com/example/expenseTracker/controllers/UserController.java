package com.example.expenseTracker.controllers;

import com.example.expenseTracker.entities.User;
import com.example.expenseTracker.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequestMapping("/api/v1/user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @GetMapping
//    public ResponseEntity<User> getUserById(@RequestParam("userId") int userId) {
//        log.info("gettring user by id : {}", userId);
//        Optional<User> userOptional = userService.getUserById(userId);
//        if (userOptional.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        } else {
//            return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
//        }
//    }

    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        log.info("gettring user by Email : {}", email);
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String email, @RequestParam String password) {
        Optional<User> userOptional = userService.getUserByEmail(email);

        if (userOptional.isEmpty()) {
            // user was not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // check if the passwords don't match
        if (!password.equals(userOptional.get().getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
