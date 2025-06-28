package com.stulikov.tasksFromInterview.firstIndex;

public class FindTheIndexOfTheFirstOccurrenceinString {

    public static void main(String[] args) {
        System.out.println(strStr("рррcode", "code"));
    }

    public static int strStr(String haystack, String needle) {

        int max = haystack.length() - needle.length();

        for (int i = 0; i <= max; i++) {

            if (haystack.regionMatches(i, needle, 0, needle.length())) {
                return i;
            }
        }

        return -1;
    }
}
