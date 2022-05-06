package y2022.m05.d05;

public class Solution_713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        if (k <= 1) {
            return ans;
        }
        for (int i = 0, j = 0, cur = 1; i < n; i++) {

            cur *= nums[i];
            //此处的while循环很好地解决了中间可能会出现计算重复数组的情况
            while (cur >= k) {
                cur /= nums[j++];
            }
            ans += i - j + 1;
        }
        return ans;
    }
}
