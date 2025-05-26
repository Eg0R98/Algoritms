package com.stulikov.tasksFromInterview.twoPoints;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[]{2,0,2,1,1,0})));
    }

    public static int[] sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while (mid <= right){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] =nums[left];
                nums[left] = temp;
                left++;
                mid++;

            } else if(nums[mid] == 1){
                mid++;
            } else{
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }

        return nums;
    }
}
