package com.stulikov.tasksFromInterview.window;

public class FindMaxAverage {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        double windowSum = 0;

        // 1. Сумма первых k элементов
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        maxSum = windowSum;

        // 2. Скользим по массиву
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];  // Добавляем новый, убираем старый
            maxSum = Math.max(maxSum, windowSum);
        }

        // 3. Делим на k, чтобы получить среднее
        return maxSum / k;
    }
}
