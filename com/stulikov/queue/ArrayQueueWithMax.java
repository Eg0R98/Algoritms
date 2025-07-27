package com.stulikov.queue;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class ArrayQueueWithMax<T> {
    private Object[] elements;     // Основной массив для хранения элементов очереди
    private int front = 0;         // Индекс начала очереди
    private int rear = 0;          // Индекс конца очереди
    private int size = 0;          // Количество элементов
    private final Comparator<T> comparator;

    private static final int DEFAULT_CAPACITY = 16;

    // Для хранения максимумов — будет работать как монотонная очередь (deque)
    private Object[] maxDeque;
    private int maxFront = 0;
    private int maxRear = 0;

    public ArrayQueueWithMax(Comparator<T> comparator) {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.maxDeque = new Object[DEFAULT_CAPACITY];
        this.comparator = comparator;
    }

    // Добавление элемента в конец очереди
    public void enqueue(T element) {
        ensureCapacity();
        elements[rear] = element;
        rear = (rear + 1) % elements.length;
        size++;

        // Обновление maxDeque: удаляем из конца все элементы меньше текущего
        while (maxSize() > 0 && comparator.compare(lastMax(), element) < 0) {
            maxRear = (maxRear - 1 + maxDeque.length) % maxDeque.length;
        }
        maxDeque[maxRear] = element;
        maxRear = (maxRear + 1) % maxDeque.length;
    }

    // Удаление элемента из начала очереди
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        T removed = (T) elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;

        // Удаление из maxDeque, если удаляемый — текущий максимум
        if (removed.equals(firstMax())) {
            maxDeque[maxFront] = null;
            maxFront = (maxFront + 1) % maxDeque.length;
        }

        return removed;
    }

    // Просмотр первого элемента
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return (T) elements[front];
    }

    // Максимум за O(1)
    @SuppressWarnings("unchecked")
    public T maxPeek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return (T) maxDeque[maxFront];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    // ===================== Вспомогательные методы =========================

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            elements = resizeArray(elements, newCapacity, front);
            front = 0;
            rear = size;

            maxDeque = resizeArray(maxDeque, newCapacity, maxFront);
            maxFront = 0;
            maxRear = maxSize();
        }
    }

    private int maxSize() {
        return (maxRear - maxFront + maxDeque.length) % maxDeque.length;
    }

    @SuppressWarnings("unchecked")
    private T firstMax() {
        return (T) maxDeque[maxFront];
    }

    @SuppressWarnings("unchecked")
    private T lastMax() {
        int lastIndex = (maxRear - 1 + maxDeque.length) % maxDeque.length;
        return (T) maxDeque[lastIndex];
    }

    private Object[] resizeArray(Object[] old, int newCap, int start) {
        Object[] newArr = new Object[newCap];
        for (int i = 0; i < size; i++) {
            newArr[i] = old[(start + i) % old.length];
        }
        return newArr;
    }
}

