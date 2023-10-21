package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.selfexception.CheckSimbolEmployeeException;
import com.kiruha.maptask.selfexception.EmployeeAlreadyAddedException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeStorageIsFullException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.kiruha.maptask.utils.EmployeeGenerator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();

    @Test
    void addEmployee() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        int passNumm = PASS_NUMM;
        double salary = SALARY;
        int departmentId = FIRST_DEPARTMENT_ID;
        Employee firstEmployee = new Employee(firstName, lastName, passNumm, salary, departmentId);

        //Подготовка ожидаемого результата
        Employee expectedEmployee = getEmployee();

        //Начало теста
        Employee actualEmployee = employeeService.addEmployee(firstEmployee, passNumm);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void add_withEmployeeStorageIsFullException() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        int passNum = PASS_NUMM;
        double salary = SALARY;
        int departmentId = FIRST_DEPARTMENT_ID;


        String firstName2 = FIRST_NAME_2;
        String lastName2 = LAST_NAME_2;
        int passNum2 = PASS_NUMM2;
        double salary2 = SALARY_2;

        String firstName3 = FIRST_NAME_3;
        String lastName3 = LAST_NAME_3;
        int passNum3 = PASS_NUMM3;
        double salary3 = SALARY_3;
        Employee firstEmployee = new Employee(firstName, lastName, passNum, salary, departmentId);
        Employee secondEmployee = new Employee(firstName2, lastName2, passNum2, salary2, departmentId);
        Employee thirdEmployee = new Employee(firstName3, lastName3, passNum3, salary3, departmentId);
        //Подготовка ожидаемого результата
        String expectedMessage = "400 Массив сотрудников переполнен";

        //Начало теста
        employeeService.addEmployee(firstEmployee, passNum);
        employeeService.addEmployee(secondEmployee, passNum2);
        Exception exception = assertThrows(
                EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee(thirdEmployee, passNum3)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void add_withEmployeeAlreadyAddedException() {
        //Подготовка входных данных
        int departmentId = FIRST_DEPARTMENT_ID;
        String firstName2 = FIRST_NAME_2;
        String lastName2 = LAST_NAME_2;
        int passNum2 = PASS_NUMM2;
        double salary2 = SALARY_2;

        Employee secondEmployee = new Employee(firstName2, lastName2, passNum2, salary2, departmentId);
        //Подготовка ожидаемого результата
        String expectedMessage = "400 Такой сотрудник уже есть";

        //Начало теста
        employeeService.addEmployee(secondEmployee, passNum2);
        Exception exception = assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee(secondEmployee, passNum2)
        );
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    void add_withCheckSimbolEmployeeException() {
        //Подготовка входных данных
        String firstName = "ad21";
        String lastName = LAST_NAME;
        int passNum = PASS_NUMM;
        double salary = SALARY;
        int departmentId = FIRST_DEPARTMENT_ID;


        String firstName2 = FIRST_NAME_2;
        String lastName2 = LAST_NAME_2;
        int passNum2 = PASS_NUMM2;
        double salary2 = SALARY_2;


        Employee firstEmployee = new Employee(firstName, lastName, passNum, salary, departmentId);
        Employee secondEmployee = new Employee(firstName2, lastName2, passNum2, salary2, departmentId);
        //Подготовка ожидаемого результата
        String expectedMessage = "400 Eror";

        //Начало теста
        employeeService.addEmployee(secondEmployee, passNum2);
        Exception exception = assertThrows(
                CheckSimbolEmployeeException.class,
                () -> employeeService.addEmployee(firstEmployee, passNum)
        );
        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    void allEmployee_successful() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        int passNum = PASS_NUMM;
        double salary = SALARY;
        int departmentId = FIRST_DEPARTMENT_ID;


        String firstName2 = FIRST_NAME_2;
        String lastName2 = LAST_NAME_2;
        int passNum2 = PASS_NUMM2;
        double salary2 = SALARY_2;

        Employee firstEmployee = new Employee(firstName, lastName, passNum, salary, departmentId);
        Employee secondEmployee = new Employee(firstName2, lastName2, passNum2, salary2, departmentId);
        //Подготовка ожидаемого результата
        List<Employee> expected = Arrays.asList(firstEmployee, secondEmployee);

        //Начало теста
        employeeService.addEmployee(firstEmployee, passNum);
        employeeService.addEmployee(secondEmployee, passNum2);

        List<Employee> actual = employeeService.allEmployee();
        assertEquals(expected, actual);
    }

    @Test
    void removeEmployee() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        int passNum = PASS_NUMM;
        double salary = SALARY;
        int departmentId = FIRST_DEPARTMENT_ID;


        String firstName2 = FIRST_NAME_2;
        String lastName2 = LAST_NAME_2;
        int passNum2 = PASS_NUMM2;
        double salary2 = SALARY_2;

        Employee firstEmployee = new Employee(firstName, lastName, passNum, salary, departmentId);
        Employee secondEmployee = new Employee(firstName2, lastName2, passNum2, salary2, departmentId);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(firstEmployee);
        employeeList.add(secondEmployee);
        for (Employee employee : employeeList) {
            if (employee.getPassportNumber().equals(passNum)) {
                employeeList.remove(employee);
            }
        }
        //Подготовка ожидаемого результата
        List<Employee> expected = employeeList;
        //Начало теста
        employeeService.addEmployee(firstEmployee, passNum);
        employeeService.addEmployee(secondEmployee, passNum2);
        employeeService.removeEmployee(passNum);

        List<Employee> actual = employeeService.allEmployee();
        assertEquals(expected, actual);

    }

    @Test
    void removeEmployeeEmployeeNotFoundException() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        int passNum = PASS_NUMM;
        double salary = SALARY;
        int departmentId = FIRST_DEPARTMENT_ID;


        String firstName2 = FIRST_NAME_2;
        String lastName2 = LAST_NAME_2;
        int passNum2 = PASS_NUMM2;
        double salary2 = SALARY_2;

        Employee firstEmployee = new Employee(firstName, lastName, passNum, salary, departmentId);
        Employee secondEmployee = new Employee(firstName2, lastName2, passNum2, salary2, departmentId);
        //Подготовка ожидаемого результата
        String expectedMessage = "400 Eror";
        //Начало теста
        employeeService.addEmployee(firstEmployee, passNum);
        employeeService.addEmployee(secondEmployee, passNum2);

        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee(584698)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void findEmployee() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        int passNum = PASS_NUMM;
        double salary = SALARY;
        int departmentId = FIRST_DEPARTMENT_ID;


        String firstName2 = FIRST_NAME_2;
        String lastName2 = LAST_NAME_2;
        int passNum2 = PASS_NUMM2;
        double salary2 = SALARY_2;

        Employee firstEmployee = new Employee(firstName, lastName, passNum, salary, departmentId);
        Employee secondEmployee = new Employee(firstName2, lastName2, passNum2, salary2, departmentId);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(firstEmployee);
        employeeList.add(secondEmployee);
        Employee findEmployee = null;
        for (Employee employee : employeeList) {
            if (employee.getPassportNumber().equals(passNum)) {
                findEmployee = employee;
            }
        }
        //Подготовка ожидаемого результата
        Employee expected = findEmployee;
        //Начало теста
        employeeService.addEmployee(firstEmployee, passNum);
        employeeService.addEmployee(secondEmployee, passNum2);

        Employee actual = employeeService.findEmployee(passNum);
        assertEquals(expected, actual);

    }

    @Test
    void findEmployeeEmployeeNotFoundException() {
        //Подготовка входных данных
        String firstName = FIRST_NAME;
        String lastName = LAST_NAME;
        int passNum = PASS_NUMM;
        double salary = SALARY;
        int departmentId = FIRST_DEPARTMENT_ID;


        String firstName2 = FIRST_NAME_2;
        String lastName2 = LAST_NAME_2;
        int passNum2 = PASS_NUMM2;
        double salary2 = SALARY_2;

        Employee firstEmployee = new Employee(firstName, lastName, passNum, salary, departmentId);
        Employee secondEmployee = new Employee(firstName2, lastName2, passNum2, salary2, departmentId);
        //Подготовка ожидаемого результата
        String expectedMessage = "400 Eror";
        //Начало теста
        employeeService.addEmployee(firstEmployee, passNum);
        employeeService.addEmployee(secondEmployee, passNum2);

        Exception exception = assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.findEmployee(584698)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

}