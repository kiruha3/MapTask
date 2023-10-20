package com.kiruha.maptask.controller.department;

import com.kiruha.maptask.EmployeeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    private final DepartmentService departmentService = new DepartmentService();

    @Test
    void minSalary() {
        //Подготовка входных данных
        double num1 = 32;
        double num2 = 14;

        //Подготовка ожидаемого результата
        String expectedResult = "Сложение: " + departmentService.minSalary();

        //Начало теста
        String actualResult = ;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void maxSalary() {
    }

    @Test
    void allDeparment() {
    }

    @Test
    void allDivideDeparment() {
    }
}