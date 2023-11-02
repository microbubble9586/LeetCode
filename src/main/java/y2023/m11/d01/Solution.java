package y2023.m11.d01;

class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int ans = 0;
        int[] cnt = new int[n + 10];
        for (int i = 0, j = 0, tot = 0; i < n; i++) {
            if (++cnt[fruits[i]] == 1) {
                tot++;
            }
            while (tot > 2) {
                if (--cnt[fruits[j++]] == 0) {
                    tot--;
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
