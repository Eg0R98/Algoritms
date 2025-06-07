package com.stulikov.tasksFromInterview.window;

import java.util.Arrays;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubArray(new int[]{1, 4, -5, 2})));
    }

    public static int[] maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0;
        int end = 0;
        int tempStart = 0; // Временный индекс начала текущего подмассива

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] > nums[i]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
                tempStart = i; // Начинаем новый подмассив с текущего элемента
            }

            // Обновляем максимум и границы
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Копируем подмассив nums[start...end] в результат
        int[] result = new int[end - start + 1];
        System.arraycopy(nums, start, result, 0, result.length);
        return result;
    }

}
