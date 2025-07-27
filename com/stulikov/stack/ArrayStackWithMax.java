package com.stulikov.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class ArrayStackWithMax<T> {
    private Object[] elements;          // Основной стек
    private Object[] maxElements;       // Стек максимумов
    private int size;                   // Текущий размер
    private final Comparator<T> comparator; // Компаратор

    private static final int DEFAULT_CAPACITY = 16;

    public ArrayStackWithMax(Comparator<T> comparator) {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.maxElements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.comparator = comparator;
    }

    // Добавление элемента в стек
    public void push(T element) {
        ensureCapacity();
        elements[size] = element;

        // Поддержка max-стека
        if (size == 0) {
            maxElements[size] = element;
        } else {
            T currentMax = max();
            maxElements[size] = comparator.compare(element, currentMax) > 0 ? element : currentMax;
        }

        size++;
    }

    // Удаление верхнего элемента
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) throw new NoSuchElementException("Stack is empty");
        size--;
        T removed = (T) elements[size];
        elements[size] = null;
        maxElements[size] = null;
        return removed;
    }

    // Получение верхнего элемента без удаления
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) throw new NoSuchElementException("Stack is empty");
        return (T) elements[size - 1];
    }

    // Получение текущего максимального элемента за O(1)
    @SuppressWarnings("unchecked")
    public T max() {
        if (size == 0) throw new NoSuchElementException("Stack is empty");
        return (T) maxElements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // Увеличение размера массивов при необходимости
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = Arrays.copyOf(elements, newCapacity);
            maxElements = Arrays.copyOf(maxElements, newCapacity);
        }
    }
}

