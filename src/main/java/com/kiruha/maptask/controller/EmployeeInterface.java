package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;

public interface EmployeeInterface {
    void addEmployee(Employee employee);

    void removeToNumEmployee(Integer i);

    Employee findToNumEmployee(Integer i);

    String allEmployee();

    String findEmployee(Employee employee);

    String removeEmployee(Employee employee);
}