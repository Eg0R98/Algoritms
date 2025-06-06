package com.stulikov.tasksFromInterview;

public class TitleToNumber {
    public static long titleToNumber(String title) {
        long result = 0;
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            int value = c - 'A' + 1;  // A->1, B->2, ..., Z->26
            result = result * 26 + value;
        }
        return result;
    }

}
