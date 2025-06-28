package com.stulikov.tasksFromInterview.charCount;

public class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("ab", "aba"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int[26];

        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                return false;
            }
            counts[c - 'a']--;
        }

        return true;

    }
}
