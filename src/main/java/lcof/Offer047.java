package lcof;

public class Offer047 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] += dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] += dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] += Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
    //第一次思路，左侧和上侧边界没有优化，导致多做判断
    /*public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (i==0&&j==0){
                    continue;
                }
                if (i==0&j!=0){
                    dp[i][j]+=dp[i][j-1]+grid[i][j];
                }else if (i!=0&&j==0){
                    dp[i][j]+=dp[i-1][j]+grid[i][j];
                } else {
                    dp[i][j] += Math.max(dp[i][j-1],dp[i-1][j])+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }*/
}
