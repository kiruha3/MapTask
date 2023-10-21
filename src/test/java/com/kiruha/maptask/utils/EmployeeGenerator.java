package com.kiruha.maptask.utils;


import com.kiruha.maptask.Employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeGenerator {

    public static final String FIRST_NAME = "Ivan";
    public static final String LAST_NAME = "Ivanov";

    public static final int PASS_NUMM = 61242;
    public static final double SALARY = 45000;

    public static final String FIRST_NAME_2 = "IvanSecond";
    public static final String LAST_NAME_2 = "IvanovSecond";
    public static final int PASS_NUMM2 = 61243;
    public static final double SALARY_2 = 34000;

    public static final String FIRST_NAME_3 = "IvanThird";
    public static final String LAST_NAME_3 = "IvanonThird";
    public static final int PASS_NUMM3 = 61244;
    public static final double SALARY_3 = 67000;

    public static final int FIRST_DEPARTMENT_ID = 1;

    public static final int SECOND_DEPARTMENT_ID = 2;

    public static Employee getEmployee() {
        return new Employee(FIRST_NAME, LAST_NAME, PASS_NUMM, SALARY, FIRST_DEPARTMENT_ID);
    }

    public static Employee getEmployee2() {
        return new Employee(FIRST_NAME_2, LAST_NAME_2, PASS_NUMM2, SALARY_2, FIRST_DEPARTMENT_ID);
    }

    public static Employee getEmployee3() {
        return new Employee(FIRST_NAME_3, LAST_NAME_3, PASS_NUMM3, SALARY_3, SECOND_DEPARTMENT_ID);
    }

    public static List<Employee> getAllEmployee() {
        return Arrays.asList(getEmployee(), getEmployee2(), getEmployee3());
    }
    public static Map<Integer,Employee>  getAllEmployee2() {
        return new HashMap<>(Map.of(PASS_NUMM, getEmployee(), PASS_NUMM2, getEmployee2(), PASS_NUMM3, getEmployee3()));
    }
}