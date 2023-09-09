package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.EmployeeService;
import com.kiruha.maptask.selfexception.EmployeeAlreadyAddedException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeInterface {
    private final EmployeeService employeeService;

    public EmployeeServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employeeService.employee.size() == employeeService.maxCountEmployee) {
            throw new EmployeeStorageIsFullException();
        } else if (employeeService.employee.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }else
            employeeService.employee.add(employee);
    }


    @Override
    public void removeToNumEmployee(Integer i) {
        if (employeeService.employee.size() > i) {
            Employee removeEmpl = employeeService.employee.get(i);
            employeeService.employee.remove(removeEmpl);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findToNumEmployee(Integer i) {
        if (employeeService.employee.size() <= i) {
            throw new EmployeeNotFoundException();
        } else {
            return employeeService.employee.get(i);
        }
    }
    @Override
    public String allEmployee() {
        return employeeService.employee.toString();

    }

    @Override
    public String findEmployee(Employee employee) {
        if (employeeService.employee.contains(employee)){
            return employeeService.employee.get(employeeService.employee.indexOf(employee)).toString();
        }else
            throw new EmployeeAlreadyAddedException();
    }

    @Override
    public String removeEmployee(Employee employee) {
        if (employeeService.employee.contains(employee)){
            return employeeService.employee.remove(employeeService.employee.indexOf(employee)).toString();
        }else
            throw new EmployeeNotFoundException();
    }


}