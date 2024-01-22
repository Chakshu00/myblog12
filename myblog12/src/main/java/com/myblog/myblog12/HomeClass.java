package com.myblog.myblog12;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HomeClass {
    public static void main(String[] args) {
       List<String> names= Arrays.asList("Chakshu","Harshit");
       Consumer<String> val=data-> System.out.println(data);
       names.forEach(val);
    }

}
