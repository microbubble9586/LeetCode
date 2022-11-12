package y2022.m11.d12;

/**
 * @author mf
 */
public class Solution {
    int MOD = (int) 1e9 + 7;

    public int numTilings(int n) {
        int[][] f = new int[n + 10][4];
        f[1][0] = f[1][1] = 1;
        f[1][2] = f[1][3] = 0;
        for (int i = 2; i <= n; i++) {
            f[i][0] = f[i - 1][1];
            int cur =0;
            for (int j = 0; j < 4; j++) {
                cur =(cur+f[i-1][j])%MOD;
            }
            f[i][1] = cur;
            f[i][2] = (f[i - 1][3] + f[i - 1][0])%MOD;
            f[i][3] = (f[i - 1][2] + f[i - 1][0])%MOD;
        }
        return f[n][1];
    }
}
