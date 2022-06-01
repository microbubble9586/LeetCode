package y2022.m06.d01;

import java.util.Arrays;

public class Solution_473_M {
    int[] ms;
    int line;

    public boolean makesquare(int[] _matchsticks) {
        ms = _matchsticks;
        int sum = 0;
        for (int matchstick : ms) {
            sum += matchstick;
        }
        //特例判断
        if (sum % 4 != 0) {
            return false;
        }
        line = sum/4;
        //特例判断
        for (int matchstick : ms) {
            if (matchstick > line) {
                return false;
            }
        }
        Arrays.sort(ms);
        return dfs(ms.length - 1, new int[4]);


    }

    private boolean dfs(int idx, int[] cur) {
        if (idx == -1) {
            return true;
        }
        out:
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                if (cur[j] == cur[i]) {
                    continue out;
                }
            }
            int u = ms[idx];
            if (cur[i] + u > line) {
                continue;
            }
            cur[i] += u;
            if (dfs(idx - 1, cur)) {
                return true;
            }
            cur[i] -= u;
        }
        return false;
    }
}
