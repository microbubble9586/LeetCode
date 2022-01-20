package y2022.m01.d20;

/**
 * 第一版不会做看的题解
 * @author chunpeng.ma
 * @version 1.0
 *
 * @date 2022/1/20 20:50
 */
public class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnts = new int[3];
        for (int i : stones) {
            cnts[i % 3]++;
        }
        return cnts[0] % 2 == 0 ?
                !(cnts[1] == 0 || cnts[2] == 0)
                : !(Math.abs(cnts[1] - cnts[2]) <= 2);

    }
}
