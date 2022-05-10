package y2022.m04.d14;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        int res =0;
        int[] wealth = new int[accounts.length];
        for (int i = 0; i < accounts.length ; i++) {
            for (int j = 0; j <accounts[0].length ; j++) {
                wealth[i]+=accounts[i][j];
            }
            if (wealth[i]>res){
                res=wealth[i];
            }
        }
        return res;
    }
}
