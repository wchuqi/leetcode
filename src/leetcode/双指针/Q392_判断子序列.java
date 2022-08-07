package leetcode.双指针;

public class Q392_判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int i=0,j=0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
