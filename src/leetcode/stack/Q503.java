package leetcode.stack;

import java.util.Stack;

public class Q503 {
    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] all = new int[nums.length];
        int n = nums.length;
        for (int i = 2*nums.length-1;i>=0;i--) {
            while (!stack.empty() && stack.peek() <= nums[i%n]) {
                stack.pop();
            }
            all[i%n] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i%n]);
        }
        return all;
    }
}
