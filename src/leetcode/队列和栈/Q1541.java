package leetcode.队列和栈;

import java.util.Stack;

//https://mp.weixin.qq.com/s/plxWQsTgW6LW3T7yBAXjQg
public class Q1541 {
    public int minInsertions(String s) {
        int leftAdd = 0, rightAdd = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                rightAdd +=2;
                if (rightAdd %2 == 1) {
                    leftAdd++;
                    rightAdd--;
                }
            }
            if (c == ')') {
                rightAdd--;
                if (rightAdd == -1) {
                    rightAdd = 1;
                    leftAdd++;
                }
            }
        }
        return  leftAdd+rightAdd;
    }
}
