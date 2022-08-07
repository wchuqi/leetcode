package leetcode.stack;

import java.util.Stack;

//https://labuladong.gitee.io/algo/2/22/62/
public class Q496 {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        int[] res = nextGreaterElement(nums1, nums2);
        System.out.println(res);
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] all = new int[nums2.length];
        for (int i = nums2.length-1;i>=0;i--) {
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            all[i] = stack.empty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i=0;i<nums1.length;i++) {
            for (int j=0;j<nums2.length;j++) {
                if (nums1[i] == nums2[j]) {
                    res[i]=all[j];
                    break;
                }
            }
        }
        return res;
    }
}
