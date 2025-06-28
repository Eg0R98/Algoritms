package com.stulikov.tasksFromInterview.stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {

    }

    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private static String build(String str) {
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                result.append(ch);
            } else if (!result.isEmpty()) {
                result.deleteCharAt(result.length() - 1); // Удаляем последний символ
            }
        }
        return result.toString();
    }
}
