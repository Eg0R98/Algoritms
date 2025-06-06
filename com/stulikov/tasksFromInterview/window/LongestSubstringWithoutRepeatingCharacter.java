package com.stulikov.tasksFromInterview.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("cabcdde"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>(); // Хранит последний индекс символа
        int left = 0;  // Начало окна
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // Если символ уже встречался и его последний индекс >= left
            if (lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= left) {
                left = lastSeen.get(currentChar) + 1;  // Сдвигаем left после дубликата
            }

            lastSeen.put(currentChar, right);  // Обновляем последний индекс символа
            maxLength = Math.max(maxLength, right - left + 1);  // Обновляем максимум
        }

        return maxLength;
    }
}
