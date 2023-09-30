package com.kiruha.maptask;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Objects;

import static org.springframework.util.StringUtils.capitalize;

public class Employee {

    private String firstName;
    private String lastName;
    private Integer passportNumber;
    private Double salary;
    private Integer department;

    public Employee(String firstName, String lastName, Integer passportNumber, Double salary, Integer department) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.passportNumber = passportNumber;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPassportNumber() {
        return passportNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getDepartment() {
        return department;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", passportNumber=" + passportNumber + '}';
    }
}