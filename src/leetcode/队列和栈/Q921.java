package leetcode.队列和栈;

import java.util.Stack;

public class Q921 {
    public int minAddToMakeValid(String s) {
        int leftAdd = 0;
        int rightAdd = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') rightAdd++;
            if (c == ')') {
                rightAdd--;
                if (rightAdd == -1) {
//                    need == -1意味着右括号太多了，所以需要插入左括号。
                    rightAdd=0;
                    leftAdd++;
                }
            }
        }
        return leftAdd+rightAdd;
    }
}
