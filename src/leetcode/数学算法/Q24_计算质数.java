package leetcode.数学算法;

import java.util.Arrays;

//https://mp.weixin.qq.com/s/EVhp3D_hwI8RFZlu5sQaIA
public class Q24_计算质数 {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i=2;i*i<n;i++) {
            if (isPrim[i]) {
                for (int j=i*i;j<n;j+=i) {
                    isPrim[j]=false;
                }
            }
        }
        int res = 0;
        for(int i=2;i<n;i++) {
            if (isPrim[i]) res++;
        }
        return res;
    }
}
