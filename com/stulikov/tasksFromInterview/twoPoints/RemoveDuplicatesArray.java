package com.stulikov.tasksFromInterview.twoPoints;

public class RemoveDuplicatesArray {
    public static void main(String[] args) {
        System.out.println(remove(new int[]{0,0,1,1,1,2,2,3,3,4}));

    }

    public static int remove(int[] arr){
        if (arr == null || arr.length ==0) return 0;
        int slow = 0;

        for (int fast = 1; fast < arr.length; fast++) {
            if(arr[fast] != arr[slow]){
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return slow+1;
    }
}
