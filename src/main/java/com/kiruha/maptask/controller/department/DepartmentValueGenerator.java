package com.kiruha.maptask.controller.department;

public class DepartmentValueGenerator {
    private static int DEFAULT_MAX = 100;
    private static int DEFAULT_MIN = 100;

    public int generateDepartmentInRange(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public int generateDepartment() {
        return generateDepartmentInRange(DEFAULT_MIN, DEFAULT_MAX);
    }

}
