package leetcode.深度搜索;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://labuladong.gitee.io/algo/4/30/110/
public class Q90 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        Arrays.sort(nums);
        backtrace(nums, 0);
        return res;
    }
    void backtrace(int[] nums, int start) {
        res.add(new LinkedList<Integer>(trace));
        for (int i=start;i<nums.length;i++) {
            if (i > start && nums[i]==nums[i-1]) {
                continue;
            }
            trace.addLast(nums[i]);
            backtrace(nums, i+1);
            trace.removeLast();
        }
    }
}
