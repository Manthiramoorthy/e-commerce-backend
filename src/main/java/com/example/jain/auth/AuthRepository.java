package com.example.jain.auth;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
