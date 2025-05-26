package com.stulikov.tasksFromInterview;

import java.util.Arrays;

public class RemovingDuplicatesFromMassive {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})));
    }

    public static int[] removeDuplicates(int[] digits) {

        int length = digits.length;

        for (int i = length-1; i >= 0 ; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] ints = new int[length + 1];

        ints[0] = 1;

        return ints;


    }
}
