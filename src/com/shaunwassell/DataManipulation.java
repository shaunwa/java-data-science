package com.shaunwassell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataManipulation {

    static class Employee {
        public final String name;
        public final Integer age;
        public final String jobTitle;
        public final Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", jobTitle='" + jobTitle + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
    public static void main(String[] args) {

        Integer[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));

        String[] wordsArr = { "hello", "data", "science", "is", "cool" };
        List<String> words = new ArrayList<>(Arrays.asList(wordsArr));

        Employee[] employeesArr = {
                new Employee("John", 34, "developer", 80000f),
                new Employee("Hannah", 24, "developer", 95000f),
                new Employee("Bart", 50, "sales executive", 100000f),
                new Employee("Sophie", 49, "construction worker", 40000f),
                new Employee("Darren", 38, "writer", 50000f),
                new Employee("Nancy", 29, "developer", 75000f),
        };
        List<Employee> employees = new ArrayList<>(Arrays.asList(employeesArr));

        List<Integer> squares = listOfIntegers.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        List<Integer> employeeAges = employees.stream()
                .map(employee -> employee.age)
                .collect(Collectors.toList());

        List<Integer> odds = listOfIntegers.stream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList());
        List<Float> developerSalaries = employees.stream()
                .filter(employee -> employee.jobTitle.equals("developer"))
                .map(employee -> employee.salary)
                .collect(Collectors.toList());

        System.out.println(developerSalaries);
    }
}
