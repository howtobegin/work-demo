package com.example.demo.jdk8.lambda;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by liuhailin on 2020/3/19.
 */
public class Demo2 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a,b,c");
        System.out.println(stream.map(s->replace(s,",")).collect(Collectors.toList()));
    }

    public static String replace(String s1, String s2) {
        return s1.replace(s2,"");
    }
}
