package com.stulikov.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi - индекс разбиения, arr[pi] теперь на правильном месте
            int pi = partition(arr, low, high);

            // Рекурсивно сортируем элементы до и после разбиения
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        // Опорный элемент (pivot), выбираем последний элемент
        int pivot = arr[high];

        // Индекс меньшего элемента
        int i = low-1;

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (arr[j] <= pivot) {
                i++;
                // Меняем arr[i] и arr[j]
                swap(arr, i, j);
            }
        }

        // Меняем arr[i+1] и опорный элемент (arr[high])
        swap(arr, i +1, high);

        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("Неотсортированный массив:");
        System.out.println(Arrays.toString(data));

        quickSort(data);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(data));
    }
}