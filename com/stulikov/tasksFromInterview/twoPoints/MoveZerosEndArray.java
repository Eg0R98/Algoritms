package com.stulikov.tasksFromInterview.twoPoints;

public class MoveZerosEndArray {

    public static void main(String[] args) {
       move(new int[]{1, 2, 0, 3, 0, 4, 4});
    }

    public static void move(int[] arr){
        if (arr == null || arr.length ==0) return;

        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {
            if(arr[fast] != 0){
                int temp = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;
                slow++;
            }
        }
    }
}
