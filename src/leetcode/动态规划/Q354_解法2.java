package leetcode.动态规划;

import java.util.Arrays;
import java.util.Comparator;

//https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484498&idx=1&sn=df58ef249c457dd50ea632f7c2e6e761&source=41#wechat_redirect
public class Q354_解法2 {
    public static void main(String[] args) {
        int[][] em = new int[][]{{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(em));
    }
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0] ? o2[1]-o1[1] : o1[0]-o2[0];
            }
        });
        int[] heigth = new int[envelopes.length];
        for (int i=0;i<heigth.length;i++) {
            heigth[i]=envelopes[i][1];
        }
        return longestIncrement(heigth);
    }
    static int longestIncrement(int[] height) {
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
