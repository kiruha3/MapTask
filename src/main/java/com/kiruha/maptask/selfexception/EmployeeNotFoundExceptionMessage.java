package com.kiruha.maptask.selfexception;

public class EmployeeNotFoundExceptionMessage extends RuntimeException {
    public EmployeeNotFoundExceptionMessage(String exception) {
        super(exception);
    }
}
