package com.stulikov.tasksFromInterview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Color {
    public static void main(String[] args) {

        // List of sock colors
        List<String> listSocks = Arrays.asList(
                "Red", "Red", "Yellow", "Yellow", "Yellow",
                "Red", "Black", "Black", "Black", "Red"
        );

        Map<String, Long> collect = listSocks.stream().collect(Collectors.groupingBy(
                n -> n,
                Collectors.counting()
        ));

        System.out.println(collect);
        //your code
    }
}

