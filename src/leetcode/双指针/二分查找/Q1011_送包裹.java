package leetcode.双指针.二分查找;

//https://mp.weixin.qq.com/s/JgJ0jh2SJd6grQSPnN6Jww
public class Q1011_送包裹 {
    public int shipWithinDays(int[] weights, int days) {
        int left=1;
        int right=1;
        for (int k : weights) {
            left = Math.max(left, k);
            right += k;
        }
        while (left <= right) {
            int mid = left + (right-left)/2;
            int temp = cost(weights, mid);
            if (temp > days) {
                left=mid+1;
            } else if (temp < days) {
                right = mid-1;
            } else if (temp == days) {
                right = mid-1;
            }
        }
        return left;
    }
    int cost(int[] weights, int k) {
        int days = 0;
        for (int i=0;i<weights.length;) {
            int temp = k;
            while (i < weights.length) {
                if (temp < weights[i]) {
                    break;
                } else {
                    temp = temp - weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }
}
