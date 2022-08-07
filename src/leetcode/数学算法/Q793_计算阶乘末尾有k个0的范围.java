package leetcode.数学算法;
//https://mp.weixin.qq.com/s/qtdSnjSBZdP64YhpQIy0HA
public class Q793_计算阶乘末尾有k个0的范围 {
    public static void main(String[] args) {
        System.out.println(preimageSizeFZF(0));
    }
    public static int preimageSizeFZF(int k) {
        return (int)right_bound(k)-(int)left_bound(k) + 1;
    }
    static long left_bound(int k) {
        long left=0,right=Long.MAX_VALUE;
        while(left <= right) {
            long mid = left + (right-left)/2;
            long temp = trailingZeroes(mid);
            if (temp > k) {
                right=mid-1;
            } else if (temp < k) {
                left=mid+1;
            } else if (temp == k) {
                right = mid-1;
            }
        }
        return left;
    }
    static long right_bound(int k) {
        long left=0,right=Long.MAX_VALUE;
        while(left <= right) {
            long mid = left + (right-left)/2;
            long temp = trailingZeroes(mid);
            if (temp > k) {
                right=mid-1;
            } else if (temp < k) {
                left=mid+1;
            } else if (temp == k) {
                left = mid+1;
            }
        }
        return right;
    }

    public static long trailingZeroes(long n) {
        long res = 0;
        long t = 5;
        while (t <= n) {
            res = res + n/t;
            t = t*5;
        }
        return res;
    }
}
