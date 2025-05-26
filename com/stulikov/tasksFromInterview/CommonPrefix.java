package com.stulikov.tasksFromInterview;

import java.util.Arrays;

public class CommonPrefix {

    public static void main(String[] args) {

        String[] array = new String[]{"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(array));
    }


    public static String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int minLength = Math.min(first.length(),
                last.length());

        int i = 0;
        while (i < minLength &&
                first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);


//        System.out.println(Arrays.toString(strs));


//        return null;
    }
}
