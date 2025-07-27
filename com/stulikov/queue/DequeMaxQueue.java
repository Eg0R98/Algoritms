package com.stulikov.queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

public class DequeMaxQueue<T> {
    private final Deque<T> queue;
    private final Deque<T> max;   // Стек, отслеживающий текущие максимумы
    private final Comparator<T> comparator; // Пользовательский компаратор (если задан)

    /**
     * Конструктор по умолчанию — сравнение через Comparable<T>.
     * Работает только с типами, реализующими Comparable.
     */
    public DequeMaxQueue() {
        this(null);
    }

    /**
     * Конструктор с поддержкой внешнего компаратора.
     *
     * @param comparator объект Comparator для сравнения элементов
     */
    public DequeMaxQueue(Comparator<T> comparator) {
        this.queue = new ArrayDeque<>();
        this.max = new ArrayDeque<>();
        this.comparator = comparator;
    }

    public void push(T value) {
        queue.add(value);
        if (max.isEmpty() || compare(value, max.peek()) >= 0) {
            max.push(value);
        }
    }

    public T pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        T removed = queue.remove();
        if (compare(removed, max.peek()) == 0) {
            max.remove();
        }
        return removed;
    }

    public T maxPeek() {
        if (max.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return max.peek();
    }

    public T peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @SuppressWarnings("unchecked")
    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        if (a instanceof Comparable) {
            return ((Comparable<T>) a).compareTo(b);
        }
        throw new IllegalStateException("Type " + a.getClass() + " must implement Comparable or provide a Comparator.");
    }

    public static void main(String[] args) {
//        Car car1 = new Car(120, 45, 9);
//        Car car2 = new Car(30, 65, 2);
//        Car car3 = new Car(150, 5, 1);
//        Car car4 = new Car(80, 35, 9);
//
//        DequeMaxQueue<Car> queue = new DequeMaxQueue<>(Comparator.comparing(Car::getPower).thenComparing(Car::getSpeed));
//        queue.push(car1);
//        queue.push(car2);
//        queue.push(car3);
//        queue.push(car4);
//
//        System.out.println(queue.maxPeek());

        DequeMaxQueue<Integer> queue = new DequeMaxQueue<>();

        queue.push(1);
        queue.push(4);
        queue.push(3);
        queue.push(1);

        System.out.println(queue.pop());
        System.out.println(queue.maxPeek());
    }
}
