package com.stulikov.tasksFromInterview.twoPoints;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;

        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(s));
    }
}
