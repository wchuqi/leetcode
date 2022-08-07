package leetcode.双指针.二分查找;

import java.util.Arrays;
import java.util.Comparator;

//https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484498&idx=1&sn=df58ef249c457dd50ea632f7c2e6e761&source=41#wechat_redirect
public class Q354 {
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
        int dump =0, n = height.length;
        int[] top = new int[n];
        for (int i=0;i<n;i++) {
            int temp = height[i];
            int left=0,right=dump-1;
            while (left<=right) {
                int mid = left + (right-left)/2;
                if (top[mid] < temp) {
                    left = mid+1;
                } else if (top[mid] > temp) {
                    right=mid-1;
                } else if (top[mid]==temp) {
                    right=mid-1;
                }
            }
//            int eee = Q35.findLeftIndex(top, temp);
            if (left == dump) dump++;
            top[left]=temp;
        }
        return dump;
    }


}
