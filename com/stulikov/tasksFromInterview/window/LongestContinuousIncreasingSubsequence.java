package com.stulikov.tasksFromInterview.window;

public class LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,2,3,-4,4,5,6}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }
        return maxLength;
    }
}
