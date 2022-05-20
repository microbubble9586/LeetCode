package y2022.m05.d20;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_436_M {
    /**
     *     今天的题目难点在于阅读理解，理解明白了就很容易做，不然题都看不懂还做个球
     *     <br/>
     *     题意：就是找当前区间所有右侧区间中，最靠左的一个
     */
    public int[] findRightInterval(int[][] its) {
        int n = its.length;
        int[][] clone = new int[n][2];
        for (int i = 0; i < n; i++) {
            clone[i] = new int[]{its[i][0], i};
        }
        Arrays.sort(clone, (a, b) -> a[0] - b[0]);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (clone[mid][0] >= its[i][1]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = clone[r][0] >= its[i][1] ? clone[r][1] : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_436_M s = new Solution_436_M();
        s.findRightInterval(new int[][]{{1, 2}});
    }
}
