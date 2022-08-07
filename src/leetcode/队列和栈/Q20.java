package leetcode.队列和栈;

import java.util.Stack;

public class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty() && leftChar(c)==stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    char leftChar(char c) {
        if (c == ')') return '(';
        if (c == '}') return '{';
        return '[';
    }
}
