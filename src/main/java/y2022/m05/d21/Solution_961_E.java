package y2022.m05.d21;

import java.util.HashMap;
import java.util.Map;

public class Solution_961_E {
    int[] cnts = new int[10010];
    public int repeatedNTimes(int[] nums) {
        for (int num : nums) {
            if (++cnts[num]>1){
                return num;
            }
        }
        return -1;
    }
    //直接采用hash方式
//    public int repeatedNTimes(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int ans = -1;
//        for (int i : nums) {
//            if (map.containsKey(i)) {
//                ans = i;
//                break;
//            } else {
//                map.put(i, 1);
//            }
//        }
//        return ans;
//    }
}
