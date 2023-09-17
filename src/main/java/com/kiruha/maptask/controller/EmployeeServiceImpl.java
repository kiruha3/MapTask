package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.EmployeeService;
import com.kiruha.maptask.selfexception.EmployeeAlreadyAddedException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {
    private final EmployeeService employeeService;

    public EmployeeServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee addEmployee(Employee employee, Integer passportNumber) {
        if (employeeService.employee.size() == employeeService.maxCountEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        if (employeeService.employee.containsKey(passportNumber)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeService.employee.put(employee.getPassportNumber(), employee);
        return employee;
    }


    @Override
    public Collection<Employee> allEmployee() {
        return employeeService.employee.values();
    }

    @Override
    public Employee findEmployee(Integer passportNumber) {
        if (employeeService.employee.containsKey(passportNumber)) {
            return employeeService.employee.get(passportNumber);
        } else
            throw new EmployeeNotFoundException();
    }

    @Override
    public Employee removeEmployee(Integer passportNumber) {
        if (employeeService.employee.containsKey(passportNumber)) {
            return employeeService.employee.remove(passportNumber);
        } else
            throw new EmployeeNotFoundException();
    }



}