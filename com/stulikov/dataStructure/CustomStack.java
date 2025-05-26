package com.stulikov.dataStructure;

public class CustomStack {
    private String[] array;
    private int k;

    public CustomStack(int n) {
        this.array = new String[n];
        this.k = -1;
    }

    public void push(String x) {
        if (k == array.length - 1) throw new RuntimeException("Stack is full");
        array[++k] = x;
    }

    public String pop() {
        if (k == -1) throw new RuntimeException("Stack is Empty");

        String res = array[k];
        array[k] = null;
        k--;
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String s : array) {
            res.append(s).append(" ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);
        stack.push("red");
        stack.push("blue");
        stack.push("white");

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push("1");
        stack.push("2");
        stack.push("3");

        System.out.println(stack);


    }
}
