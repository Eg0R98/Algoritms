package com.stulikov.sorting;

import java.util.Arrays;

public class MergeSort {

    // Основной метод для вызова сортировки
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // Массив уже отсортирован
        }
        int[] temp = new int[array.length]; // Временный массив для слияния
        mergeSort(array, temp, 0, array.length - 1);
    }

    // Рекурсивный метод сортировки
    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Находим середину

            // Рекурсивно сортируем левую и правую половины
            mergeSort(array, temp, left, mid);
            mergeSort(array, temp, mid + 1, right);

            // Сливаем отсортированные половины
            merge(array, temp, left, mid, right);
        }
    }

    // Метод слияния двух отсортированных подмассивов
    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        // Копируем обе части во временный массив
        System.arraycopy(array, left, temp, left, right - left + 1);

        int i = left;      // Индекс начала левой части
        int j = mid + 1;   // Индекс начала правой части
        int k = left;      // Индекс для вставки в исходный массив

        // Слияние: выбираем меньший элемент из двух подмассивов
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        // Докопируем оставшиеся элементы левой части
        while (i <= mid) {
            array[k++] = temp[i++];
        }

        // Правую часть докопировать не нужно - она уже на месте
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6, 7};
        System.out.println("Неотсортированный массив:");
        System.out.println(Arrays.toString(data));

        mergeSort(data);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(data));
    }
}
