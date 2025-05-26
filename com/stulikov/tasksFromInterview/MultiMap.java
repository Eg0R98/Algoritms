package com.stulikov.tasksFromInterview;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MultiMap {
    public static void main(String[] args) {
        Map<Integer, List<Long>> map = new HashMap<>();
        map.put(1, Arrays.asList(0L, 1L, 2L));
        map.put(2, Arrays.asList(3L, 4L));


        Set<Integer> keySet = map.keySet();

        Map<Long, Integer> result = new HashMap<>();

        for (Integer key : keySet) {
            List<Long> values = map.get(key);
            for(Long value : values){
                result.put(value, key);
            }
        }

        System.out.println(result);

        Map<Long, Integer> longIntegerMap = map.entrySet().stream().flatMap(entry -> {
            Integer key = entry.getKey();
            List<Long> listValue = entry.getValue();
            return listValue.stream().map(value -> Map.entry(value, key));
        }).collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        System.out.println(longIntegerMap);

    }
}
