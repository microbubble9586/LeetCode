package y2023.m11.d02;

public class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 10];
        int tot = 0;
        int ans = 0;
        for (int i = 0, j = 0, p = 0; i < n; i++) {
            if (++cnt[nums[i]] == 1) {
                tot++;
            }
            if (tot > k) {
                cnt[nums[j]]--;
                j++;
                p = 0;
                tot--;
            }
            while (cnt[nums[j]] > 1) {
                cnt[nums[j]]--;
                j++;
                p++;
            }
            if (tot == k) {
                ans += p + 1;
            }
        }
        return ans;
    }
}
