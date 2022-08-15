package y2022.m08.d14;

/**
 * @description:
 * @author：MF
 * @date: 2022/8/15
 */
public class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] pres = new int[n+10];
        for(int i =1;i<=n;i++){
            int x = s.charAt(i-1)=='0'?1:0;
            pres[i] = pres[i-1]+x;
        }
        int ans = 0;
        for(int i = 1;i<=n-1;i++){
            int a = pres[i];
            int b = (n-i)-(pres[n]-pres[i]);
            ans =  Math.max(ans,a+b);
        }
        return ans;
    }
}
