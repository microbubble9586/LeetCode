package y2022.m01.d18;

import java.util.Arrays;
import java.util.List;

/**
 * @author chunpeng.ma
 * @version 1.0
 * @description: 0
 * @date 2022/1/18 22:19
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size() * 2;
        int[] minResult = new int[size];
        for (int i = 0, index = 0; i < size; i++, index += 2) {
            String[] split = timePoints.get(i).split(":");
            int h = Integer.parseInt(split[0]), m = Integer.parseInt(split[1]);
            minResult[index] = h * 60 + m;
            minResult[index + 1] = minResult[index] + 1440;
        }
        Arrays.sort(minResult);
        int result = minResult[1] - minResult[0];
        for (int i = 0; i < size - 1; i++) {
            result = Math.min(result, minResult[i + 1] - minResult[i]);
        }
        return result;
    }
}
