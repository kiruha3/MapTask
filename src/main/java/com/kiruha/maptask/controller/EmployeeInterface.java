package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.selfexception.CheckSimbolEmployeeException;

import java.util.Collection;

public interface EmployeeInterface {
    Employee addEmployee(Employee employee, Integer passportNumber);

    Collection<Employee> allEmployee();

    Employee findEmployee(Integer passportNumber);

    Employee removeEmployee(Integer passportNumber);

    Employee isCheckFirstSimbol(String firstName, String lastName) throws CheckSimbolEmployeeException;
}