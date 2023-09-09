package com.kiruha.maptask.controller;


import com.kiruha.maptask.Employee;
import com.kiruha.maptask.selfexception.EmployeeAlreadyAddedException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String addEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam("lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            employeeServiceImpl.addEmployee(employee);
            return "Сотрудник успешно добавлен ";
        } catch (EmployeeStorageIsFullException e) {
            return "ArrayIsFull ";
        } catch (EmployeeAlreadyAddedException e) {
            return "EmployeeAlreadyAdded";
        }
    }

    @GetMapping(path = "/findToNum")
    public String findToNumEmployer(@RequestParam(value = "num", required = false) Integer i) {
        try {
            employeeServiceImpl.findToNumEmployee(i);
            String str = employeeServiceImpl.findToNumEmployee(i).toString();
            return "пользователь под номером " + i + "\n" + str;
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound" + i;
        }
    }

    @GetMapping(path = "/find")
    public String findEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                               @RequestParam(value = "lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            return employeeServiceImpl.findEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound";
        }
    }

    @GetMapping(path = "/removeToNum")
    public String removeToNumEmployer(@RequestParam(value = "num", required = false) Integer i) {
        try {
            employeeServiceImpl.removeToNumEmployee(i);
            return "Успешно удален пользователем под номером " + i;
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound" + i;
        }
    }

    @GetMapping(path = "/remove")
    public String removeEmployer(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        try {
            Employee employee = new Employee(firstName, lastName);
            return employeeServiceImpl.removeEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return "EmployeeNotFound";
        }
    }

    @GetMapping(path = "/all")
    public String allEmployer() {
        return employeeServiceImpl.allEmployee().toString();
    }

}
