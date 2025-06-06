package com.stulikov.tasksFromInterview;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,9})));
    }

    public static int[] plusOne(int[] digits){

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
