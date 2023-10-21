package com.kiruha.maptask.controller.department;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.controller.EmployeeService;
import com.kiruha.maptask.selfexception.EmployeeNotFoundExceptionMessage;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

@Service
public class DepartmentService implements DepartmentInterface {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee minSalary(Integer department) {
        return employeeService.allEmployee().stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundExceptionMessage("exception"));

    }
    @Override
    public double sumDepartmentSalary(Integer department) {
        return employeeService.allEmployee().stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .mapToInt(i -> i.getSalary().intValue()).sum();

    }

    @Override
    public Employee maxSalary(Integer department) {
        return employeeService.allEmployee().stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(() -> new EmployeeNotFoundExceptionMessage("exception"));

    }

    @Override
    public Map<Integer, List<Employee>> allDeparment(Integer department) {
        return employeeService.allEmployee().stream()
                .filter(e -> department == null || e.getDepartment() == department)
                .collect(groupingBy(Employee::getDepartment, toList()));


    }


    @Override
    public Map<Integer, List<Employee>> allDivideDeparment() {
        return employeeService.allEmployee()
                .stream()
                .collect(groupingBy(Employee::getDepartment));

    }

}
