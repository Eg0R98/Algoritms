package com.stulikov.tasksFromInterview;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,4,5}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {

            // If k is found or needs to be inserted
            // before nums[i]
            if(nums[i] >= target) {
                return i;
            }
        }
        // If k is greater than all elements,
        // insert at the end
        return nums.length;
    }
}
