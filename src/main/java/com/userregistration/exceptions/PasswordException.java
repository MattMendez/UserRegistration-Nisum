package com.userregistration.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PasswordException extends RuntimeException {

    private String code;

    private HttpStatus status;

    public PasswordException() {
        super("The password does not comply with the correct syntax");
        this.code = "400";
        this.status = HttpStatus.BAD_REQUEST;
    }
}