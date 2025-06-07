package com.stulikov.tasksFromInterview.window;

public class MinSubArrayLen {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4, new int[]{1,-4,5,3,1}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Сдвигаем левую границу, пока сумма ≥ target
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;

    }
}
