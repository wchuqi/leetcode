package leetcode.深度搜索;

import java.util.LinkedList;
import java.util.List;

// https://labuladong.gitee.io/algo/4/30/110/
public class Q77 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> trace = new LinkedList<>();
        int[] nums = new int[n];
        for (int i=1;i<=n;i++) {
            nums[i-1]=i;
        }
        backtrace(nums, k,0);
        return res;
    }
    void backtrace(int[] nums, int k, int start) {
        if (trace.size() == k) {
            res.add(new LinkedList<Integer>(trace));
        }
        for (int i=start;i<nums.length;i++) {
            trace.addLast(nums[i]);
            backtrace(nums,k, i+1);
            trace.removeLast();
        }
    }
}
