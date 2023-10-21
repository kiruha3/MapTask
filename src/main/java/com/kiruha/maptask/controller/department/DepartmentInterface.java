package com.kiruha.maptask.controller.department;

import com.kiruha.maptask.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentInterface {

    Employee minSalary(Integer departmentId);

    Employee maxSalary(Integer departmentId);

    Map<Integer, List<Employee>> allDeparment(Integer department);

    Map<Integer, List<Employee>> allDivideDeparment();
}
