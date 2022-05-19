package y2022.m05.d19;

import java.util.Arrays;

public class Solution_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, t = nums[(n - 1) / 2], ans = 0;
        for (int i : nums) {
            ans += Math.abs(t - i);
        }
        return ans;
    }
}
