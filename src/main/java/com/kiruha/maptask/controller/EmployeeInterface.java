package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface EmployeeInterface {
    Employee addEmployee(Employee employee, Integer passportNumber);

    Collection<Employee> allEmployee();

    Employee findEmployee(Integer passportNumber);

    Employee removeEmployee(Integer passportNumber);


    Optional<Double> minSalary(Integer departmentId);

    Optional<Double> maxSalary(Integer departmentId);

    Stream<Employee> allDeparment(Integer department);

    List<Employee> allDivideDeparment();
}