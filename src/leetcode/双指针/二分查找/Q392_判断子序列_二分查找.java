package leetcode.双指针.二分查找;

import java.util.ArrayList;
import java.util.List;

//https://mp.weixin.qq.com/s/hWi2hTrQewL_YKioGkXQJg
public class Q392_判断子序列_二分查找 {
    public boolean isSubsequence(String s, String t) {
        int m=s.length(),n=t.length();
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i=0;i<n;i++) {
            char c = t.charAt(i);
            if (index[c] == null) index[c] = new ArrayList<>();
            index[c].add(i);
        }
        int j=0;
        for (int i=0;i<m;i++) {
            char c = s.charAt(i);
            if (index[c] == null) return false;
            int pos = left_bound(index[c], j);
            if (pos == index[c].size()) return false;
            j = index[c].get(pos)+1;
        }
        return true;
    }
    int left_bound(List<Integer> nums, int target) {
        int left=0,right=nums.size()-1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (nums.get(mid) < target) {
                left=mid+1;
            } else if(nums.get(mid)>target) {
                right=mid-1;
            } else if (nums.get(mid) == target) {
                right=mid-1;
            }
        }
        return left;
    }
}
