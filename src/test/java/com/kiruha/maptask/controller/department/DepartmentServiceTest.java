package com.kiruha.maptask.controller.department;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private final DepartmentService departmentService = new DepartmentService();

    @Test
    void minSalary() {
        //Подготовка входных данных
        Integer department = 2;

        //Подготовка ожидаемого результата
        Employee expectedResult = departmentService.minSalary(department);

        //Начало теста
        Employee actualResult = departmentService.minSalary(department) ;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void maxSalary() {
        //Подготовка входных данных
        Integer department = 2;

        //Подготовка ожидаемого результата
        Employee expectedResult = departmentService.maxSalary(department);

        //Начало теста
        Employee actualResult = departmentService.maxSalary(department) ;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void allDeparment() {
        //Подготовка входных данных
        Integer department = 2;

        //Подготовка ожидаемого результата
        Collection<Employee> expectedResult = departmentService.allDeparment(department);

        //Начало теста
        Collection<Employee> actualResult = departmentService.allDeparment(department) ;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void allDivideDeparment() {
        //Подготовка входных данных

        //Подготовка ожидаемого результата
        Map<Integer, List<Employee>> expectedResult = departmentService.allDivideDeparment();

        //Начало теста
        Map<Integer, List<Employee>> actualResult = departmentService.allDivideDeparment() ;
        assertEquals(expectedResult, actualResult);
    }
}