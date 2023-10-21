package com.kiruha.maptask.selfexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CheckSimbolEmployeeException extends HttpStatusCodeException {

    public CheckSimbolEmployeeException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
