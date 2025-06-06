package com.stulikov.tasksFromInterview.strings;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(99));
    }

    public static String intToRoman(int num) {
        int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40,  10,  9,   5,  4,   1};
        String[] symbols = {"M", "CM","D", "CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                builder.append(symbols[i]);
            }
        }


        return builder.toString();

    }
}
