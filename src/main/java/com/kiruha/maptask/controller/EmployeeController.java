package com.kiruha.maptask.controller;


import com.kiruha.maptask.Employee;
import com.kiruha.maptask.selfexception.EmployeeAlreadyAddedException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

import java.util.Optional;
import java.util.stream.Stream;

//@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceimpl) {
        this.employeeServiceImpl = employeeServiceimpl;
    }

    @GetMapping()
    public String logInPage() {
        return "Приветствую вас на стартовой странице";
    }

    @GetMapping(path = "/add")
    public Employee addEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("passnum") Integer passportNumber,
                                @RequestParam("salary") Double salary,
                                @RequestParam("department") Integer department) {
        try {
            Employee employee = new Employee(firstName, lastName, passportNumber, salary, department);
            System.out.println("Сотрудник успешно добавлен ");
            return employeeServiceImpl.addEmployee(employee, passportNumber);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("ArrayIsFull ");
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("EmployeeAlreadyAdded");
        }
        return null;
    }


    @GetMapping(path = "/find")
    public Employee findEmployer(@RequestParam("passnum") Integer passportNumber) {
        try {
            return employeeServiceImpl.findEmployee(passportNumber);
        } catch (EmployeeNotFoundException e) {
            System.out.println("EmployeeNotFound");
        }
        return null;
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployer(@RequestParam("passnum") Integer passportNumber) {
        try {
            return employeeServiceImpl.removeEmployee(passportNumber);
        } catch (EmployeeNotFoundException e) {
            System.out.println("EmployeeNotFound");
        }
        return null;
    }

    @GetMapping(path = "departments/min-salary")
    public Optional<Double> minSalaryFindInDepartment(@RequestParam("departmentId") Integer department) {
        return employeeServiceImpl.minSalary(department);
    }
    @GetMapping(path = "departments/max-salary")
    public Optional<Double> maxSalaryFindInDepartment(@RequestParam("departmentId") Integer department) {
        return employeeServiceImpl.maxSalary(department);
    }
    @GetMapping(path = "departments/all")
    public Stream<Employee> allDepartment(@RequestParam("departmentId") Integer department) {
        return employeeServiceImpl.allDeparment(department);
    }
    @GetMapping(path = "departments/alll")
    public Collection<Employee> allDivideDepartment() {
        return employeeServiceImpl.allDivideDeparment();
    }
    @GetMapping(path = "/all")
    public List<Employee> allEmployer() {
        return (List<Employee>) employeeServiceImpl.allEmployee();
    }

}
