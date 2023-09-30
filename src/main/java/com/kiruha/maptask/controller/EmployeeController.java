package com.kiruha.maptask.controller;


import com.kiruha.maptask.Employee;
import com.kiruha.maptask.selfexception.CheckSimbolEmployeeException;
import com.kiruha.maptask.selfexception.EmployeeAlreadyAddedException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RequestMapping("/employee")
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
            System.out.println("Попытка ");
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

    @GetMapping(path = "/all")
    public Collection<Employee> allEmployer() {
        return employeeServiceImpl.allEmployee();
    }

//    @GetMapping(path = "/check-first-simbol")
//    //тестовые
//    //добавление
//    //http://localhost:8080/employee/add?firstName=третьяков&lastName=кирилл&passnum=9543&salary=2004&department=1
//    //http://localhost:8080/employee/check-first-simbol?firstName=третьяков&lastName=третьяков
//    public Employee checkFirstSimbol(@RequestParam(value = "firstName", required = false) String firstName,
//                                     @RequestParam("lastName") String lastName) {
//        try {
//            return employeeServiceImpl.isCheckFirstSimbol(firstName, lastName);
//        } catch (CheckSimbolEmployeeException e) {
//            System.out.println("Exception");
//        }
//        return null;
//    }

}
