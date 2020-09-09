package com.quanghuy.spring.controller;

import com.quanghuy.spring.data.User;
import com.quanghuy.spring.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public ResponseEntity getAllUser() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable("id") long id, @RequestBody User user) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()) return ResponseEntity.notFound().build();
        User updateUser = foundUser.get();
        updateUser.setUsername(user.getUsername());
        userRepository.save(updateUser);
        return ResponseEntity.ok("Success");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) return ResponseEntity.notFound().build();
        userRepository.delete(user.get());
        return ResponseEntity.ok("Success");
    }
}
