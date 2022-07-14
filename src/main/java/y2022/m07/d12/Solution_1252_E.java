package y2022.m07.d12;

public class Solution_1252_E {
    public int oddCells(int m, int n, int[][] indices) {
        boolean[] r = new boolean[m],c = new boolean[n];
        int a =0,b=0;
        for(int[] index : indices){
            a += (r[index[0]] = !r[index[0]])?1:-1;
            b += (c[index[1]] = !c[index[1]])?1:-1;
        }
        return a*(n-b) + (m-a)*b;
    }
}
