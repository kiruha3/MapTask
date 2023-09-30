package com.kiruha.maptask.controller.department;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.EmployeeService;
import com.kiruha.maptask.selfexception.EmployeeNotFoundExceptionMessage;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentInterface {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee minSalary(Integer department) {
        return employeeService.employee.values()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundExceptionMessage("exception"));

    }

    @Override
    public Employee maxSalary(Integer department) {
        return employeeService.employee.values()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundExceptionMessage("exception"));

    }

    @Override
    public Collection<Employee> allDeparment(Integer department) {
        return employeeService.employee.values()
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .collect(Collectors.toList());


    }


    @Override
    public Map<Integer, List<Employee>> allDivideDeparment() {
        return employeeService.employee.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

    }

}
