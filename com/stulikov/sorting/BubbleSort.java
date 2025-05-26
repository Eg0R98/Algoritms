package com.stulikov.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        // Внешний цикл - количество проходов по массиву
        for (int i = 0; i < n - 1; i++) {
            // Внутренний цикл - сравнение соседних элементов
            for (int j = 0; j < n - i - 1; j++) {
                // Если текущий элемент больше следующего - меняем местами
                if (array[j] > array[j + 1]) {
                    // Обмен элементов
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Неотсортированный массив:");
        System.out.println(Arrays.toString(data));

        bubbleSort(data);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(data));
    }
}
