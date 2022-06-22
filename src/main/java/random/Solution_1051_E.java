package random;

import java.util.Arrays;

public class Solution_1051_E {
    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int[] ex = Arrays.copyOf(heights,n);
        int[] clone = heights.clone();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (heights[i] != ex[i]) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        heightChecker(new int[]{1,1,4,2,1,3});
    }
}
