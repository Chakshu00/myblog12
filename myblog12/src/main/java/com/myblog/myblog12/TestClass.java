package com.myblog.myblog12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClass {
    public static void main(String[] args) {
       List<String> names=Arrays.asList("Chakshu","Chetan","Kapil","Harshit");
        String collect = names.stream().filter(n -> n.contains("h")).map(n -> n.toUpperCase()).collect(Collectors.joining());
        System.out.println(collect);
    }


}
