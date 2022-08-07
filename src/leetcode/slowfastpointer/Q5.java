package leetcode.slowfastpointer;

public class Q5 {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i=0;i<s.length();i++) {
            String s1 = find(s, i, i);
            String s2 = find(s, i,i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
    String find(String s, int left, int right) {
        while (left >=0 && right < s.length()
                && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    /*class Solution {
        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                // 以 s[i] 为中心的最长回文子串
                String s1 = palindrome(s, i, i);
                // 以 s[i] 和 s[i+1] 为中心的最长回文子串
                String s2 = palindrome(s, i, i + 1);
                // res = longest(res, s1, s2)
                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }
            return res;
        }

        String palindrome(String s, int l, int r) {
            // 防止索引越界
            while (l >= 0 && r < s.length()
                    && s.charAt(l) == s.charAt(r)) {
                // 向两边展开
                l--;
                r++;
            }
            // 返回以 s[l] 和 s[r] 为中心的最长回文串
            return s.substring(l + 1, r);
        }
    }*/

}
