package com.stulikov.tasksFromInterview.charCount;

import java.util.Arrays;

public class PermutationString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidabooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Заполняем частоты s1 и первого окна s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        // Сравниваем частоты
        if (Arrays.equals(s1Count, windowCount)) return true;

        // Скользим по s2
        for (int i = s1.length(); i < s2.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++; // добавляем новый символ справа
            windowCount[s2.charAt(i - s1.length()) - 'a']--; // удаляем старый слева

            if (Arrays.equals(s1Count, windowCount)) return true;
        }

        return false;
    }
}
