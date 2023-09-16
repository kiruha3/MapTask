package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public interface EmployeeInterface {
    Employee addEmployee(Employee employee, Integer passportNumber);

    Collection<Employee> allEmployee();

    Employee findEmployee(Integer passportNumber);

    Employee removeEmployee(Integer passportNumber);


    Employee minSalary(Integer departmentId);

    Employee maxSalary(Integer departmentId);

    Stream<Employee> allDeparment(Integer department);

    Map<Integer, List<Employee>> allDivideDeparment();
}