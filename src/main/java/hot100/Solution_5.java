package hot100;

/**
 * 最长回文子串
 */
public class Solution_5 {
    public String longestPalindrome(String s) {
        /*
           最长回文子串，想到的方式是双指针从标记点向两端扩散，找到对应的两端的值是否相等，
           不等就结束，并记录两端位置和长度，进而想到一种动态规划做法，为了减少重复计算，
           用二维数组记录两端点ij是否位回文串，由此优化代码
         */
        if(s==null||s.length()<2){
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int maxLen =1;
        int begin = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    if (i-j<3){
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j+1][i-1];
                    }
                    if (dp[j][i]&&maxLen<i-j+1){
                        maxLen = i-j+1;
                        begin = j;
                    }
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {

    }
}
