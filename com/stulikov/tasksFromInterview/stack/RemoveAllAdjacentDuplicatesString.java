package com.stulikov.tasksFromInterview.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);

           if(stack.isEmpty() || stack.peek() != c){
               stack.push(c);
           } else if(c == stack.peek()) {
                stack.pop();
           }
        }

        return stack.toString();
    }
}
