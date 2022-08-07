package leetcode.广度搜索;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");
        while (!q.isEmpty()) {
            int len = q.size();
            for (int k=0;k<len;k++) {
                String cur = q.poll();
                if (deads.contains(cur)) continue;
                if (cur.equals(target)) return step;

                for (int i=0;i<4;i++) {
                    String plus = plusOne(cur, i);
                    if (!visited.contains(plus)) {
                        q.offer(plus);
                        visited.add(plus);
                    }
                    String down = minusOne(cur, i);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    String plusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i] = (char)((int)ch[i]+1);
        }
        return new String(ch);
    }
    String minusOne(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] = (char)((int)ch[i]-1);
        }
        return new String(ch);
    }
}
