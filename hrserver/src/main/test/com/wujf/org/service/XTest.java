package com.wujf.org.service;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class XTest {
    @Test
    public void test01() {
        String[] strings = {"hello","hello"};
        String[] strings1 = {"hello","criswu"};
        String[] strings2 = {"hello","hha"};
        Stream<String> s1 = Arrays.stream(strings);
        Stream<String> s2 = Arrays.stream(strings1);
        Stream<String> s3 = Arrays.stream(strings2);
//        Stream<String> ss = Stream.of(s1,s2,s3).flatMap(Function.identity());
//        System.out.println(ss.anyMatch(s -> s.equals("criswu")));
//        System.out.println(s1.allMatch(s -> s.equals("hello")));
//        System.out.println(s2.noneMatch(s -> s.equals("abc")));
        int sum = IntStream.range(1, 101).reduce(1,Integer::sum);
        System.out.println(sum);
    }
}
