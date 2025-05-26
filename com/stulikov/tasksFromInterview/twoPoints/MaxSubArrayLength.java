package com.stulikov.tasksFromInterview.twoPoints;

public class MaxSubArrayLength {

    public static void main(String[] args) {
        System.out.println(max(new int[]{1, 2, 3, 4, 2}, 6));
    }

    public static int max(int[] arr, int target){
        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > target && left <= right){
                sum -= arr[left];
                left++;
            }

            if(sum == target){
                maxLen = Math.max(maxLen, right-left+1);
            }
        }
        return maxLen;
    }
}
