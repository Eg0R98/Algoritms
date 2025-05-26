package com.stulikov.tasksFromInterview;

import java.util.Arrays;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climb(n, memo);
    }

    private static int climb(int n, int[] memo) {
        if (n <= 2) return n;

        if (memo[n] != -1) return memo[n];

        memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
        return memo[n];
    }
}
