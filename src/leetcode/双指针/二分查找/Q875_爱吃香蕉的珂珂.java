package leetcode.双指针.二分查找;

//https://mp.weixin.qq.com/s/JgJ0jh2SJd6grQSPnN6Jww

//1 <= piles[i] <= 10^9
public class Q875_爱吃香蕉的珂珂 {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=1000000000;
        while(left <= right) {
            int mid = left+(right-left)/2;
            int temp = cost(piles, mid);
            if (temp > h) {
                left=mid+1;
            } else if (temp < h) {
                right = mid-1;
            } else if (temp == h) {
                right = mid -1;
            }
        }
        return left;
    }
    int cost(int[] piles, int k) {
        int res = 0;
        for(int i=0;i<piles.length;i++) {
            res += piles[i]/k;
            if (piles[i]%k != 0) res++;
        }
        return res;
    }
}
