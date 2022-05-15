package y2022.m05.d15;

public class Solution_812 {
    public  double largestTriangleArea(int[][] ps) {
        int n = ps.length;
        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int cur = cross(ps[j][0] - ps[i][0], ps[j][1] - ps[i][1], ps[k][0] - ps[i][0], ps[k][1] - ps[i][1]);
                    ans = Math.max(ans, Math.abs(cur / 2.0));
                }
            }
        }
        return ans;
    }
    int cross(int a, int b, int c, int d) {
        return a * d - c * b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_812().largestTriangleArea(new int[][]{
                {1, 0}, {0, 0}, {0, 1}
        }));
    }
}
