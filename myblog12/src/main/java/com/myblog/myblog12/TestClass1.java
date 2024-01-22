package com.myblog.myblog12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
       List<Employee> employees= Arrays.asList(
               new Employee("mike",30,"Chennai"),
               new Employee("adam",25,"Chennai"),
               new Employee("stallin",31,"pune"),
               new Employee("pankaj",34,"banglore")
       );

        Map<Integer, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e -> e.getAge()));
       for(Map.Entry<Integer, List<Employee>>entry:collect.entrySet()){
           int age=entry.getKey();
           List<Employee> EmployeesWithAge = entry.getValue();
           System.out.println("age:"+age+"----");
           for(Employee e:EmployeesWithAge){
               System.out.println(e.getCity());
               System.out.println(e.getName());
           }
       }
    }
}
