package org.example.leetcode;

import java.util.Stack;

/**
 * проверить валидность скобок
 * РЕШЕНИЯ:
 * если открывающая скобка - пихаем ее в стек
 * если закрывающая - должна соответствовать верхней в стеке
 */
public class LC20 {

    public static void main(String[] args) {
        System.out.println(isValid("{{{}}}"));
        System.out.println(isValid("{{()[]{)}}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch (current) {
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                default -> stack.push(current);
            }
        }
        return stack.isEmpty();
    }

}
