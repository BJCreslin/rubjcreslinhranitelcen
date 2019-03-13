package ru.bjcreslin.willdelete;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SolutionString {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hi hello goodmorning ass".split("\\s"));
        changeList(list).stream().forEach(System.out::println);

    }

    static List<String> changeList(List<String> list) {
        Collections.sort(list, Comparator.comparing(String::length));
        String maxWord = list.get(list.size() - 1);
        List<String> list1 = list.stream().map((String x) -> maxWord).collect(Collectors.toList());
        return list1;
    }

    public static long factorial(long n) {

        return LongStream.range(1, n + 1).reduce((pre, cur) -> pre * cur).getAsLong();


    }

}
