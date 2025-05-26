package com.stulikov.tasksFromInterview.twoPoints;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionTwoArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersections2(new int[]{1,2,2,1}, new int[]{2,2})));
    }

    public static int[] intersactions1(int[] nums1, int[] nums2){

        Set<Integer> set =  Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        int[] array = Arrays.stream(nums2).filter(set::contains).distinct().toArray();


        return array;
    }

    public static int[] intersections2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }

        return result;
    }
}
