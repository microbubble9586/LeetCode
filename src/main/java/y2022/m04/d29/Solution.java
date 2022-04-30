package y2022.m04.d29;

public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for (int i = 0,j=n-1; i < j; i++) {
            if (nums[i]%2==1){
                int c = nums[j];
                nums[j--]=nums[i];
                nums[i--]=c;
            }
        }
        return nums;
    }
}
