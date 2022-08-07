package leetcode.stack;

import java.util.Stack;

public class Q739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] all = new int[temperatures.length];
        for (int i = temperatures.length-1;i>=0;i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            all[i] = stack.empty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        return all;
    }
}
