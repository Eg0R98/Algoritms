package com.stulikov.tasksFromInterview;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt1(8));
    }

    public static int sqrt1(int x) {
        long left = 0, right = (x/2)+1;

        while (left<right){
            long mid = left + (right - left)/2+1;
            long square = mid * mid;

            if (square == x){
                return (int) mid;
            } else if (square < x) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return (int) left;
        }


    public static int mySqrt(int number) {
        double x = number;
        double root;

        while (true) {
            root = 0.5 * (x + (number / x));

            // Погрешность
            if (Math.abs(root - x) < 0.000001) {
                break;
            }

            x = root;
        }
        return (int) root;
    }

    public static double sqrt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Невозможно вычислить корень из отрицательного числа");
        }
        if (number == 0 || number == 1) {
            return number;
        }

        double start = 0;
        double end = number;
        double mid = 0;

        double epsilon = 0.000001;

        while ((end - start) > epsilon) {
            mid = (start + end) / 2;

            if (mid * mid < number) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return (start + end) / 2;
    }

}
