package com.example.jain.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    String SECURITY_KEY = "24370hfkohyrq398yiohewrfwuigfe9hrfiuh";
    long EXPIRATION = 1 * 60 * 60 * 1000;

    public String generateToken(String username) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS256, SECURITY_KEY)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
        .setSigningKey(SECURITY_KEY)
        .parseClaimsJws(token)
        .getBody()
        .getSubject();

    }
}
