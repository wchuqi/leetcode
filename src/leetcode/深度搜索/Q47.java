package leetcode.深度搜索;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * https://labuladong.gitee.io/algo/4/30/110/
 *
 */

public class Q47 {
    List<List<Integer>> res = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        LinkedList<Integer> trace = new LinkedList<>();
        Arrays.sort(nums);
        backtrace(nums, trace);
        return res;
    }
    void backtrace(int[] nums, LinkedList<Integer> trace) {
        if (trace.size() == nums.length) {
            res.add(new LinkedList<Integer>(trace));
            return;
        }
        for (int i=0;i<nums.length;i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i]==nums[i-1] && !used[i-1]) {
                continue;
            }
            trace.add(nums[i]);
            used[i]=true;
            backtrace(nums, trace);
            trace.removeLast();
            used[i]=false;
        }
    }
}
