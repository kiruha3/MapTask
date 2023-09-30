package com.kiruha.maptask.selfexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CheckSimbolEmployeeException extends RuntimeException{
    public CheckSimbolEmployeeException() {
    }

    public CheckSimbolEmployeeException(String message) {
        super(message);
    }

    public CheckSimbolEmployeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckSimbolEmployeeException(Throwable cause) {
        super(cause);
    }

    public CheckSimbolEmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
