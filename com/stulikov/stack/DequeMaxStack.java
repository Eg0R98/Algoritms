package com.stulikov.stack;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/**
 * Обобщённый стек, поддерживающий операцию maxPeek() за O(1).
 * Позволяет использовать как Comparable-объекты, так и внешние Comparator'ы.
 *
 * @param <T> тип элементов, которые будут храниться в стеке
 */
public class DequeMaxStack<T> {
    private final Deque<T> stack;      // Основной стек
    private final Deque<T> maxStack;   // Стек, отслеживающий текущие максимумы
    private final Comparator<T> comparator; // Пользовательский компаратор (если задан)

    /**
     * Конструктор по умолчанию — сравнение через Comparable<T>.
     * Работает только с типами, реализующими Comparable.
     */
    public DequeMaxStack() {
        this(null);
    }

    /**
     * Конструктор с поддержкой внешнего компаратора.
     *
     * @param comparator объект Comparator для сравнения элементов
     */
    public DequeMaxStack(Comparator<T> comparator) {
        this.stack = new ArrayDeque<>();
        this.maxStack = new ArrayDeque<>();
        this.comparator = comparator;
    }

    /**
     * Добавляет элемент в стек.
     * Если элемент больше либо равен текущему максимуму, добавляется и в maxStack.
     *
     * @param value значение, которое добавляется
     */
    public void push(T value) {
        stack.push(value);
        if (maxStack.isEmpty() || compare(value, maxStack.peek()) >= 0) {
            maxStack.push(value);
        }
    }

    /**
     * Удаляет верхний элемент из стека и возвращает его.
     * Если этот элемент является текущим максимумом, он также удаляется из maxStack.
     *
     * @return удалённое значение
     * @throws RuntimeException если стек пуст
     */
    public T pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T removed = stack.pop();
        if (compare(removed, maxStack.peek()) == 0) {
            maxStack.pop();
        }
        return removed;
    }

    /**
     * Возвращает текущий максимум в стеке за O(1).
     *
     * @return текущий максимум
     * @throws RuntimeException если стек пуст
     */
    public T maxPeek() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return maxStack.peek();
    }

    /**
     * Возвращает верхний элемент стека (но не удаляет его).
     *
     * @return верхнее значение
     * @throws RuntimeException если стек пуст
     */
    public T peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peek();
    }

    /**
     * Проверяет, пуст ли стек.
     *
     * @return true, если стек пуст, иначе false
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Сравнивает два элемента между собой.
     * Если задан компаратор — используется он, иначе — пытаемся привести к Comparable<T>.
     *
     * @param a первый элемент
     * @param b второй элемент
     * @return результат сравнения: < 0, = 0 или > 0
     * @throws IllegalStateException если не задан ни компаратор, ни Comparable
     */
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
        Car car1 = new Car(120, 45, 9);
        Car car2 = new Car(30, 65, 2);
        Car car3 = new Car(150, 5, 1);
        Car car4 = new Car(80, 35, 9);

        DequeMaxStack<Car> stack = new DequeMaxStack<>(Comparator.comparing(Car::getPower).thenComparing(Car::getSpeed));
        stack.push(car1);
        stack.push(car2);
        stack.push(car3);
        stack.push(car4);

        System.out.println(stack.maxPeek());

    }

    public static class Car {
        private int speed;
        private int mass;
        private int power;

        public Car(int speed, int mass, int power) {
            this.speed = speed;
            this.mass = mass;
            this.power = power;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getMass() {
            return mass;
        }

        public void setMass(int mass) {
            this.mass = mass;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "speed=" + speed +
                    ", mass=" + mass +
                    ", power=" + power +
                    '}';
        }
    }
}



