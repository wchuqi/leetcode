package leetcode.深度搜索;

import java.util.LinkedList;
import java.util.List;

// https://labuladong.gitee.io/algo/4/30/110/
class Q216 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k,int n) {
        int[] nums = new int[9];
        for (int i=1;i<=9;i++) {
            nums[i-1]=i;
        }
        backtrace(nums, 0, k,n, 0);
        return res;
    }
    void backtrace(int[] nums, int start, int k,int n,int sum) {
        if (sum > n) {
            return;
        }
        if (trace.size() > k) {
            return;
        }
        if (sum == n && trace.size() ==k) {
            res.add(new LinkedList<Integer>(trace));
        }

        for (int i=start;i<nums.length;i++) {
            trace.addLast(nums[i]);
            sum += nums[i];
            backtrace(nums,i+1,k,n, sum);
            trace.removeLast();
            sum -=nums[i];
        }
    }
}

