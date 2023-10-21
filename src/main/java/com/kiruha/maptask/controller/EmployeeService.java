package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.selfexception.CheckSimbolEmployeeException;
import com.kiruha.maptask.selfexception.EmployeeAlreadyAddedException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.containsNone;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeService implements EmployeeInterface {
    public final Integer maxCountEmployee = 5;
    public Map<Integer,Employee> employees = new HashMap<>(Map.of(
            6554,new Employee("Ольга", "Васнецова", 6554, 35000.00, 1),
            6555, new Employee("Василий", "Синицин",6555,25000.00,1),
            6556,new Employee("Инга", "Третьякова",6556,15000.00,2),
            6557,new Employee("Виталя", "Носков",6557,54000.00,2) ));


    @Override
    public Employee addEmployee(Employee employee, Integer passportNumber) {

        if (employees.size() == maxCountEmployee) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        if (employees.containsKey(passportNumber)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        if (!validateImput(employee.getFirstName(), employee.getLastName())) {
            throw new CheckSimbolEmployeeException("Eror");
        }
        employees.put(employee.getPassportNumber(), employee);
        return employee;
    }


    @Override
    public List<Employee> allEmployee() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee findEmployee(Integer passportNumber) {
        if (employees.containsKey(passportNumber)) {
            return employees.get(passportNumber);
        } else
            throw new EmployeeNotFoundException("Eror");
    }

    @Override
    public Employee removeEmployee(Integer passportNumber) {
        if (employees.containsKey(passportNumber)) {
            return employees.remove(passportNumber);
        } else
            throw new EmployeeNotFoundException("Eror");
    }

    @Override
    public Employee isCheckFirstSimbol(String firstName, String lastName) {
        List<Employee> employeeList = new ArrayList<Employee>(employees.values());
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getFirstName(), firstName) && Objects.equals(employee.getLastName(), lastName)) {
                if (!employee.getFirstName().startsWith(employee.getFirstName(), 1)
                        && !employee.getLastName().startsWith(employee.getLastName(), 1)) {
                    throw new CheckSimbolEmployeeException("Eror");
                }
                if (containsNone(employee.getFirstName(), "!.,_ ")
                        && containsNone(employee.getLastName(), "!.,_ ")) {
                    throw new CheckSimbolEmployeeException("Eror");
                } else {
                    return employee;
                }
            }
        }
        return null;
    }

    private boolean validateImput(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }
}