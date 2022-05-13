package com.userregistration.services;

import com.userregistration.dtos.request.NewUserRequest;
import com.userregistration.dtos.response.NewUserResponse;
import com.userregistration.entities.User;
import com.userregistration.exceptions.EmailException;
import com.userregistration.exceptions.PasswordException;
import com.userregistration.exceptions.SqlException;
import com.userregistration.exceptions.UserAlreadyExistException;
import com.userregistration.repositories.UserRepository;
import com.userregistration.utils.JwtUtil;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Value("${user.email.regex}")
    private String emailRegex;

    @Value("${user.password.regex}")
    private String passwordRegex;

    public boolean patternMatches(String string, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(string)
                .matches();
    }

    public ResponseEntity registerNewUser(NewUserRequest newUser) {

        if(userRepository.findByEmail(newUser.getEmail()).isPresent()){
            log.error("A user already exist with email " + newUser.getEmail());
            throw new UserAlreadyExistException();
        }else if( !patternMatches(newUser.getEmail(), emailRegex)) {
            log.error("The email does not comply with the correct syntax (Example: aaaaaaa@dominio.cl )");
            throw new EmailException();
        }else if( !patternMatches(newUser.getPassword(), passwordRegex)){
            log.error("The password does not comply with the correct syntax");
            throw new PasswordException();
        }

        User user = newUser.toEntity();

        user.setToken(new JwtUtil().generateToken(user));

        try {
            user = userRepository.save(user);
        }catch (Exception exception){
            log.error(exception.getMessage());
            throw new SqlException();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new NewUserResponse().toResponse(user));
    }


    public ResponseEntity findAllUsers(String token) {
        new JwtUtil().decodeToken(token);

        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }
}
