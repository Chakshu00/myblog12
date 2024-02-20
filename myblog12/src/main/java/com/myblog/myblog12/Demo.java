package com.myblog.myblog12;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {

        List<Student> studs= Arrays.asList(
                new Student("Chakshu",23),
                new Student("Harshit",22),
                new Student("Kapil",27)
        );

        List<String> collect = studs.stream().filter(i -> i.getAge() > 22).map(i -> i.getName()).collect(Collectors.toList());
        System.out.println(collect);
    }
}