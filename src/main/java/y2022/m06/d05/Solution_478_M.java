package y2022.m06.d05;

import java.util.Random;

public class Solution_478_M {
    double r, x, y;
    Random random = new Random();
    public Solution_478_M(double r, double x, double y) {
//    public Solution(double r, double x, double y) {
        this.r=r;
        this.x = x;
        this.y = y;
    }
    public double[] randPoint() {
        double len = Math.sqrt(random.nextDouble(r * r)), ang = random.nextDouble(2 * Math.PI);
        double nx = x + len * Math.cos(ang), ny = y + len * Math.sin(ang);
        return new double[]{nx, ny};
    }
}
