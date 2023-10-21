package com.kiruha.maptask.selfexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class EmployeeNotFoundException extends HttpStatusCodeException {
    public EmployeeNotFoundException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
