package com.userregistration.controllers;

import com.userregistration.dtos.ExceptionDto;
import com.userregistration.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = PasswordException.class)
    public ResponseEntity<ExceptionDto> passwordExceptionHandler(PasswordException ex){
        ExceptionDto exceptionDto = ExceptionDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(exceptionDto, ex.getStatus());
    }

    @ExceptionHandler(value = UserAlreadyExistException.class)
    public ResponseEntity<ExceptionDto> UserAlreadyExistExceptionHandler(UserAlreadyExistException ex){
        ExceptionDto exceptionDto = ExceptionDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(exceptionDto, ex.getStatus());
    }

    @ExceptionHandler(value = EmailException.class)
    public ResponseEntity<ExceptionDto> EmailExceptionHandler(EmailException ex){
        ExceptionDto exceptionDto = ExceptionDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(exceptionDto, ex.getStatus());
    }

    @ExceptionHandler(value = SqlException.class)
    public ResponseEntity<ExceptionDto> SqlException(EmailException ex){
        ExceptionDto exceptionDto = ExceptionDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(exceptionDto, ex.getStatus());
    }

    @ExceptionHandler(value = JwtException.class)
    public ResponseEntity<ExceptionDto> JwtException(EmailException ex){
        ExceptionDto exceptionDto = ExceptionDto.builder().code(ex.getCode()).message(ex.getMessage()).build();
        return new ResponseEntity<>(exceptionDto, ex.getStatus());
    }

}
