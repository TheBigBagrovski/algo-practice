package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * <p>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * <p>
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class LC150 {

    public static void main(String[] args) {
        String[] arr = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(noStack(arr));
     }

    public static int noStack(String[] s) { // O(N), O(N) тк создаем лист
        List<String> t = new ArrayList<>(List.of(s));
        for (int i = 2; i < t.size();) {
            if (isOperator(t.get(i))) {
                int left = Integer.parseInt(t.get(i - 2));
                int right = Integer.parseInt(t.get(i - 1));
                int result = 0;
                if (t.get(i).equals("+")) result = left + right;
                else if (t.get(i).equals("-")) result = left - right;
                else if (t.get(i).equals("*")) result = left * right;
                else result = left / right;

                t.set(i - 2, Integer.toString(result));
                t.remove(i - 1);
                t.remove(i - 1);
                i = i - 1;
            } else {
                i++;
            }
        }
        return Integer.parseInt(t.get(t.size() - 1));
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static int evalRPN(String[] tokens) { // O(N), O(N)
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int x = stack.pop();
                    stack.push(stack.pop() - x);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int x = stack.pop();
                    stack.push(stack.pop() / x);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

}
