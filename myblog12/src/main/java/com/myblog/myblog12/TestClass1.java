package com.myblog.myblog12;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//13
public class TestClass1 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);

        List<Integer> collect = list1.stream().limit(4).collect(Collectors.toList());
        System.out.println(collect);

//    List<String> names= Arrays.asList("mike","adam","harshit","stallin","harshit");
//
//    names.stream().distinct().forEach(s-> System.out.println(s));
//        long count = names.stream().distinct().count();
//        System.out.println(count);
    }
}