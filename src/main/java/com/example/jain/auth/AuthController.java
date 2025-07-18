package com.example.jain.auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3020/")
public class AuthController {

    AuthService service;

    AuthController(AuthService authService) {
        this.service = authService;
    }

    @PostMapping("login")
    public String login(@RequestBody User user) {
        return service.login(user);
    }

    @PostMapping("register")
    public String register(@RequestBody User user) {
        // TODO: process POST request

        return service.register(user);
    }

}
