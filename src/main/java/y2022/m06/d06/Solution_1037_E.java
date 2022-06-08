package y2022.m06.d06;

public class Solution_1037_E {
    public boolean isBoomerang(int[][] ps) {
        return (ps[1][0]-ps[0][0])*(ps[2][1]-ps[0][1])
                !=(ps[2][0]-ps[0][0])*(ps[1][1]-ps[0][1]);
    }
    //x1*y2-x2*y1
    //向量叉积计算，可用于判断向量是否共线，和两个向量的顺逆时针方向关系
}
