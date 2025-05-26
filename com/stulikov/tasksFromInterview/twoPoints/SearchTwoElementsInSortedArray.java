package com.stulikov.tasksFromInterview.twoPoints;

import java.util.Arrays;

public class SearchTwoElementsInSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[]{1, 2, 3, 4, 5}, 2)));
    }

    public static int[] search(int[] arr, int target){
        if (arr == null || arr.length < 2) return null;

        int left = 0;
        int right = arr.length-1;

        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum == target){
                return new int[]{arr[left], arr[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
