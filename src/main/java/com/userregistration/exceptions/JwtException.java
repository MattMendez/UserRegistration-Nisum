package com.userregistration.exceptions;

import org.springframework.http.HttpStatus;

public class JwtException extends RuntimeException {

    private String code;

    private HttpStatus status;

    public JwtException() {
        super("Could not verify JWT token integrity!");
        this.code = "403";
        this.status = HttpStatus.BAD_REQUEST;
    }
}
