package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;

import java.util.Collection;

public interface EmployeeInterface {
    Employee addEmployee(Employee employee, Integer passportNumber);

    Collection<Employee> allEmployee();

    Employee findEmployee(Integer passportNumber);

    Employee removeEmployee(Integer passportNumber);


}