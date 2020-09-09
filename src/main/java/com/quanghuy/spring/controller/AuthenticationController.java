package com.quanghuy.spring.controller;

import com.quanghuy.spring.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
//    @Autowired
//    AuthenticationManager authenticationManager;
//
//    @Autowired
//    JwtProvider jwtProvider;

    @PostMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password){

    }
}
