package leetcode.队列和栈;

import java.util.Stack;

public class Q32 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[n+1];
        for (int i=0;i<n;i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
                dp[i+1]=0;
            } else if (!stack.isEmpty()) {
                int leftIndex = stack.pop();
                int len = i - leftIndex+1 + dp[leftIndex];
                dp[i+1] = len;
            } else {
                dp[i+1] = 0;
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }
}
