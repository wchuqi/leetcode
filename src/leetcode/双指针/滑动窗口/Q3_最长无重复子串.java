package leetcode.双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

public class Q3_最长无重复子串 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left=0,right=0;
        int res = 0;
        while (right<s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c,0)+1);
            while (window.get(c) >1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d)-1);
            }
            res = Math.max(res, right-left);
        }
        return res;
    }
}
