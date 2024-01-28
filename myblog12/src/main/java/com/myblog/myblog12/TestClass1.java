package com.myblog.myblog12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestClass1 {
    public static void main(String[] args) {
       List<String> names= Arrays.asList("Akash","Ankit","Chakshu");
        Optional<String> firstNameA = names.stream().map(i -> i.toLowerCase()).filter(i -> i.startsWith("a")).findFirst();

        if(firstNameA.isPresent()){
            System.out.println(firstNameA.get());
        }else{
            System.out.println("No name is present with letter 'a'");
        }
    }
}
