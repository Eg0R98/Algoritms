package com.stulikov.tasksFromInterview;

public class IntegerReverse {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

    public static boolean isPalindrome(int x) {
       if(x < 0) return false;
        var primary = x;
        var reversed = 0;
        var digit = 0;
        while(x!=0){
            digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }

        return reversed == primary;

    }

    public static int reverse(int x) {
        var reversed = 0L;
        var digit = 0;


        while(x!=0){
            digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;

        }

        return (int) reversed;
    }
}
