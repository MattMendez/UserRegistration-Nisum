package com.userregistration.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class EmailException extends RuntimeException {

    private String code;

    private HttpStatus status;

    public EmailException() {
        super("The email does not comply with the correct syntax (Example: aaaaaaa@dominio.cl )");
        this.code = "400";
        this.status = HttpStatus.BAD_REQUEST;
    }

}
