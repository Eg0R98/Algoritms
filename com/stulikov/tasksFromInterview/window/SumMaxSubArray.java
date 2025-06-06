package com.stulikov.tasksFromInterview.window;

public class SumMaxSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1,2,3,-4,5}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); // "Окно" или новый элемент
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
