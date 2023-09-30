package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.EmployeeService;
import com.kiruha.maptask.selfexception.EmployeeAlreadyAddedException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

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

    @Override
    public Employee isCheckFirstSimbol(String firstName, String lastName) {
        List<Employee> employeeList = new ArrayList<Employee>(employeeService.employee.values());
        //http://localhost:8080/employee/check-first-simbol?firstName=виталя&lastName=Носков
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getFirstName(), firstName) && Objects.equals(employee.getLastName(), lastName)) {
                if (!employee.getFirstName().startsWith(employee.getFirstName(), 1)&&!employee.getLastName().startsWith(employee.getLastName(), 1)) {
                    throw new RuntimeException();
                }else
                    return employee;
            }
        }
        return null;
    }


}