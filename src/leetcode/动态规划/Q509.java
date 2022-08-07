package leetcode.动态规划;

/**
 * 这题本身肯定是没有难度的，但是斐波那契数列可以帮你由浅入深理解动态规划算法的原理，建议阅读详细题解。
 *
 */
public class Q509 {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int dp0 = 0, dp1 = 1;
        for (int i=2; i<=n;i++) {
            int temp = dp0 + dp1;
            dp0 = dp1;
            dp1 = temp;
        }
        return dp1;
    }
}
