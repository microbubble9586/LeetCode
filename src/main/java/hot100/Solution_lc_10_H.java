package hot100;

public class Solution_lc_10_H {
    public static boolean isMatch(String ss, String pp) {
        int m  = ss.length(),n=pp.length();
        ss = " "+ss;
        pp = " "+ pp;
        char[] s = ss.toCharArray(),p = pp.toCharArray();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 0;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(j+1<=n && p[j+1]=='*'){
                    continue;
                }

                if(i-1>=0&&p[j]!='*'){
                    dp[i][j] = dp[i-1][j-1]&&(s[i]==p[j]||p[j]=='.');
                } else if(p[j]=='*'){
                    dp[i][j] = (j-2>=0&&dp[i][j-2])||(i-1>=0&&dp[i-1][j]&&(s[i]==p[j-1]||p[j-1]=='.'));
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", "abc*d*"));
    }
}
