package com.kiruha.maptask.controller.department;

import com.kiruha.maptask.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalaryFindInDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.minSalary(department);
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalaryFindInDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.maxSalary(department);
    }
    @GetMapping(path = "/summDepartmentSalary")
    public double summDepartmentSalary(@RequestParam("departmentId") Integer department) {
        return departmentService.sumDepartmentSalary(department);
    }


    @GetMapping(path = "/all", params = {"departmentId"})
    public Map<Integer, List<Employee>> allDepartment(@RequestParam("departmentId") Integer department) {
        return departmentService.allDeparment(department);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allDivideDepartment() {
        return departmentService.allDivideDeparment();
    }
}
