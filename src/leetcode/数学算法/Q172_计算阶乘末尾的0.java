package leetcode.数学算法;
//https://mp.weixin.qq.com/s/qtdSnjSBZdP64YhpQIy0HA
public class Q172_计算阶乘末尾的0 {
    public int trailingZeroes(int n) {
        int res = 0;
        int t = 5;
        while (t <= n) {
            res = res + n/t;
            t = t*5;
        }
        return res;
    }
}
