package leetcode.剑指offer;

import java.util.HashSet;
import java.util.Set;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//0 <= nums.length <= 104
//-109 <= nums[i] <= 109
//时间复杂度为 O(n) 的解决方案

//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4
public class Q119_最长递增子序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int n : nums) {
            sets.add(n);
        }
        int res = 0;
        for (int n : sets) {
            if (!sets.contains(n-1)) {
                int temp = n;
                int t2 = 1;
                while (sets.contains(temp+1)) {
                    temp = temp+1;
                    t2++;
                }
                res = Math.max(res, t2);
            }
        }
        return res;
    }
}
