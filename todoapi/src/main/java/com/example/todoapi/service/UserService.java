package com.example.todoapi.service;

import com.example.todoapi.models.Users;
import com.example.todoapi.repository.UserRepo;
import com.example.todoapi.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //Register
    public Users register(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    //Login
    public String login(Users user) {

        if (user.getUsername() == null || user.getPassword() == null) {
            return "INVALID REQUEST";
        }

        Users dbUser = userRepo.findByUsername(user.getUsername());

        if (dbUser == null) {
            return "USER NOT FOUND";
        }

        if (!bCryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            return "WRONG PASSWORD";
        }

        return JwtUtil.generateToken(dbUser.getUsername());
    }
}
