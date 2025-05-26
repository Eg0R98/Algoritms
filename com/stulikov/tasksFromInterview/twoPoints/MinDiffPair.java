package com.stulikov.tasksFromInterview.twoPoints;

import java.util.Arrays;

public class MinDiffPair {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(search(new int[]{6, 1, 4, 2, 9, 7})));
    }

    public static int[] search(int[] arr){
        if (arr == null || arr.length < 2) return null;

        Arrays.sort(arr);

        int left = 0;
        int right = 1;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (right < arr.length){
            int diff = arr[right] - arr[left];
            if(diff < minDiff){
                minDiff = diff;
                result[0] = arr[left];
                result[1] = arr[right];
            }
            left++;
            right++;
        }
        return result;
    }
}

