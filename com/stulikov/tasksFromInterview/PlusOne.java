package com.stulikov.tasksFromInterview;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
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
