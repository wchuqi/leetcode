package leetcode.动态规划;

import java.util.Arrays;

//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
public class Q300_最长连续字序列 {
    public int lengthOfLIS(int[] height) {
        int n = height.length;
        int[] dp = new int[n];
        int res =1;
        for (int i=0;i<n;i++) {
            dp[i]=1;
            for(int j=0;j<i;j++) {
                if (height[j] < height[i]) {
                    dp[i]=Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public int lengthOfLIS_1(int[] height) {
        int[] dp = new int[height.length];
        Arrays.fill(dp, 1);
        for (int i=0;i<height.length;i++) {
            for (int j=0;j<i;j++) {
                if (height[j]<height[i]) {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i=0;i<height.length;i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
