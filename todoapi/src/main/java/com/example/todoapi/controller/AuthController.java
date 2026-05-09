package com.example.todoapi.controller;

import com.example.todoapi.models.Users;
import com.example.todoapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping ("/login")
    public String login(@RequestBody Users user) {
        return userService.login(user);
    }

}
