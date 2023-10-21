package com.kiruha.maptask.controller;

import com.kiruha.maptask.Employee;
import com.kiruha.maptask.controller.EmployeeService;
import com.kiruha.maptask.controller.department.DepartmentService;
import com.kiruha.maptask.selfexception.EmployeeNotFoundException;
import com.kiruha.maptask.selfexception.EmployeeNotFoundExceptionMessage;
import com.kiruha.maptask.utils.EmployeeGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static com.kiruha.maptask.utils.EmployeeGenerator.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {


    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentService departmentService;
    @InjectMocks
    private EmployeeGenerator employeeGenerator;

    @Test
    void getEmployeeWithMaxSalary_success() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        List<Employee> employeeList= Arrays.asList(getEmployee(), getEmployee2(), getEmployee3());
        //Подготовка ожидаемого результата
        when(employeeService.allEmployee()).thenReturn(employeeList);

        Employee expectedEmployee = getEmployee();

        //Начало теста
        Employee actualEmployee = departmentService.maxSalary(departmentId);
        assertEquals(expectedEmployee, actualEmployee);
        assertTrue(getEmployee().getSalary() > getEmployee2().getSalary());
    }

    @Test
    void getEmployeeWithMaxSalary_withEmployeeNotFoundException() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.allEmployee()).thenReturn(Collections.emptyList());

        String expectedMessage = "exception";

        //Начало теста
        Exception exception = assertThrows(
                EmployeeNotFoundExceptionMessage.class,
                () -> departmentService.maxSalary(departmentId)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getEmployeeWithMinSalary_success() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.allEmployee()).thenReturn(getAllEmployee());

        Employee expectedEmployee = getEmployee2();

        //Начало теста
        Employee actualEmployee = departmentService.minSalary(departmentId);
        assertEquals(expectedEmployee, actualEmployee);
        assertTrue(getEmployee().getSalary() > getEmployee2().getSalary());
    }

    @Test
    void getEmployeeWithMinSalary_withEmployeeNotFoundException() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.allEmployee()).thenReturn(Collections.emptyList());

        String expectedMessage = "exception";

        //Начало теста
        Exception exception = assertThrows(
                EmployeeNotFoundExceptionMessage.class,
                () -> departmentService.minSalary(departmentId)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void getEmployeesByDepartment_withDepartmentId() {
        //Подготовка входных данных
        Integer departmentId = FIRST_DEPARTMENT_ID;

        //Подготовка ожидаемого результата
        when(employeeService.allEmployee()).thenReturn(getAllEmployee());

        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(FIRST_DEPARTMENT_ID, Arrays.asList(getEmployee(), getEmployee2()));

        //Начало теста
        Map<Integer, List<Employee>> actualMap = departmentService.allDeparment(departmentId);
        assertEquals(expectedMap, actualMap);
        assertEquals(getEmployee().getDepartment(), getEmployee2().getDepartment());
        assertNotEquals(getEmployee().getDepartment(), getEmployee3().getDepartment());
    }

    @Test
    void getEmployeesByDepartment_withoutDepartmentId() {
        //Подготовка входных данных
        Integer departmentId = null;

        //Подготовка ожидаемого результата
        when(employeeService.allEmployee()).thenReturn(getAllEmployee());

        Map<Integer, List<Employee>> expectedMap = new HashMap<>();
        expectedMap.put(FIRST_DEPARTMENT_ID, Arrays.asList(getEmployee(), getEmployee2()));
        expectedMap.put(SECOND_DEPARTMENT_ID, Collections.singletonList(getEmployee3()));

        //Начало теста
        Map<Integer, List<Employee>> actualMap = departmentService.allDeparment(departmentId);
        assertEquals(expectedMap, actualMap);
        assertEquals(getEmployee().getDepartment(), getEmployee2().getDepartment());
        assertNotEquals(getEmployee().getDepartment(), getEmployee3().getDepartment());
    }
}