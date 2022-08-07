package leetcode.双指针.滑动窗口;

import java.util.HashMap;
import java.util.Map;

//https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&chksm=9bd7f8ddaca071cbb7570b2433290e5e2628d20473022a5517271de6d6e50783961bebc3dd3b&scene=178&cur_album_id=2120601117519675393#rd
public class Q567_是否存在子串符合排列之一 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int valid = 0;
        while ((right<s2.length())) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while(right-left>=s1.length()) {
                if (valid == need.size()) return true;
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return false;
    }
}
