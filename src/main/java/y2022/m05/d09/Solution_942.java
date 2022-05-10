package y2022.m05.d09;

import java.util.Arrays;

public class Solution_942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int l =0,r=n;
        int[] ans = new int[n + 1];
        Arrays.fill(ans, 0);
        for (int i = 0; i < n; i++) {
            ans[i] = s.charAt(i) == 'I'?l++:r--;
        }
        ans[n]= l;
        return ans;
    }
}
