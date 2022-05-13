package com.userregistration.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UserAlreadyExistException extends RuntimeException {

    private String code;

    private HttpStatus status;

    public UserAlreadyExistException() {
        super("A user already exist with that email");
        this.code = "400";
        this.status = HttpStatus.BAD_REQUEST;
    }

}