package com.stulikov.tasksFromInterview.window;

public class Fibonatchi {

    public static void main(String[] args) {
    printFibonacciLessThan(9);
    }

    public static void printFibonacciLessThan(int n) {
        int a = 0;
        int b = 1;

        while (a < n) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }

}
