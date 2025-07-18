package com.example.jain.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jain.jwt.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JwtUtil jwtUtil;

    String login(User user) {
        try {
            System.out.println(user.username);

            User existingUser = authRepository.findByUsername(user.username);
            if (existingUser.password.equals(user.password)) {
                return jwtUtil.generateToken(user.username);
            } else {
                return "Invalid credentails";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    String register(User user) {
        if (authRepository.findByUsername(user.username) == null) {
            try {
                authRepository.save(user);
                return "Success";
            } catch (Exception e) {
                return e.getMessage();
            }
        } else {
            return "User already registered";
        }
    }
}