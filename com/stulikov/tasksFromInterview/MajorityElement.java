package com.stulikov.tasksFromInterview;

import java.util.HashMap;
import java.util.Map.Entry;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3, 2}));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);

            }
        }

        Integer i = map.entrySet().stream().max(Entry.comparingByValue()).map(Entry::getKey).orElse(null);

        return i;
    }
}
