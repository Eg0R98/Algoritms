package com.stulikov.reflection;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();

        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(2.0);

        list.parallelStream().reduce((accumulator, element) ->accumulator*element).ifPresent(System.out::println);
    }
}
