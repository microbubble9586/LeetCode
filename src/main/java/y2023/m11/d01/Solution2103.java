package y2023.m11.d01;

public class Solution2103 {
    public int countPoints(String s) {
        int n = s.length(), ans = 0;
        int[] map = new int[128];
        for (int i = 0; i < n; i += 2) map[s.charAt(i) - 'B'] |= 1 << (s.charAt(i + 1) - '0');
        for (int i = 0; i < 10; i++) {
            int tot = 0;
            for (char c : new char[]{'R', 'G', 'B'}) tot += (map[c - 'B'] >> i) & 1;
            if (tot == 3) ans++;
        }
        return ans;
    }

}
