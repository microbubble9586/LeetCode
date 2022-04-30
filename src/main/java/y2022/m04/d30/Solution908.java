package y2022.m04.d30;

import java.util.Arrays;

public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0],min= nums[0];
        for (int num : nums) {
            max = Math.max(num,max);
            min = Math.min(num,min);
        }
        return Math.max(0,max-min-2*k);
    }
}
