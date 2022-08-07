package leetcode.双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/minimum-window-substring/solution/hua-dong-chuang-kou-mo-ban-jie-jue-yi-qi-v6gn/
public class Q76_最小子串包含所有字符 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left=0, right=0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start =0,len=Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right-left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start+len);
    }
}
