package com.userregistration.utils;

import com.userregistration.entities.User;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class JwtUtil {

    public static String generateToken(User user) {

        try {
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;
            HashMap<String, Object> header = new HashMap<String, Object>();
            header.put("alg", signatureAlgorithm.toString());
            header.put("typ", "JWT");

            JwtBuilder tokenJWT = Jwts
                    .builder()
                    .setHeader(header)
                    .setId("1")
                    .setSubject("http://nisum.com")
                    .claim("name", user.getName())
                    .claim("email", user.getEmail())

                    .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
                    .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
                    .signWith(SignatureAlgorithm.HS256, "secretkey");

            String tokenJWTString = tokenJWT.compact();
            System.out.println(tokenJWTString);
            return tokenJWTString;

        } catch (Exception ex) {
            return "Error creating the token JWT" + ex.getMessage();
        }
    }
}