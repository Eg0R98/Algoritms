package com.stulikov.tasksFromInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * Найти первый не повторяющийся элемент в массиве целых чисел
 */
public class FirstUnique {
    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 6, 7, 4, 5, 1, 0, 9, -1};
        int n = getFirstUnique(arr);
        System.out.println(n); // ожидается: 6
    }

    static int getFirstUnique(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Считаем количество повторений
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Находим первый уникальный
        for (int num : arr) {
            if (freq.get(num) == 1) {
                return num;
            }
        }

        // Если нет уникальных
        throw new IllegalArgumentException("Нет уникальных элементов");
    }
}
