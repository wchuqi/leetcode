package leetcode.深度搜索;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://labuladong.gitee.io/algo/4/30/110/
class Q40 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrace(candidates, 0, target, 0);
        return res;
    }
    void backtrace(int[] nums, int start, int target, int sum) {
        if (sum == target) {
            res.add(new LinkedList<Integer>(trace));
        }
        if (sum > target) {
            return;
        }
        for (int i=start;i<nums.length;i++) {
            if (i > start && nums[i]==nums[i-1]) {
                continue;
            }
            trace.addLast(nums[i]);
            sum += nums[i];
            backtrace(nums,i,target, sum);
            trace.removeLast();
            sum -=nums[i];
        }
    }
}

