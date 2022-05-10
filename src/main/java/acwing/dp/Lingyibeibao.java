package acwing.dp;

/**
 * @author 0_0
 */
public class Lingyibeibao {
    /**
     *
     * @param volume N个物体的体积
     * @param wealth 第N个物体的价值
     * @param N 数量
     * @param V 背包容量
     * @return 最大价值
     */
    public  static int dynamicProgramming0_1(int[] volume,int[] wealth,int N,int V){
        int X = 1010;
        int[][] f = new int[X][X];
        for (int i  = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (j<volume[i]){
                    f[i][j] = f[i-1][j];
                } else {
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-volume[i]]+wealth[i]);
                }
            }
        }
        return f[N][V];
    }

    public static void main(String[] args) {
        int[] v = new int[]{0,1,2,3,4};
        int[] w = new int[]{0,2,4,4,5};
        int count = 4;
        int volume = 5;
        dynamicProgramming0_1(v,w,count, volume);
    }
}
