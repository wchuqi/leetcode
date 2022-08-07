package leetcode.深度搜索;

import java.util.LinkedList;
import java.util.List;

// https://labuladong.gitee.io/algo/4/30/110/
public class Q78 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> trace = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> trace = new LinkedList<>();
        backtrace(nums, 0);
        return res;
    }
    void backtrace(int[] nums, int start) {
        res.add(new LinkedList<Integer>(trace));
        for (int i=start;i<nums.length;i++) {
            trace.addLast(nums[i]);
            backtrace(nums, i+1);
            trace.removeLast();
        }
    }
}
