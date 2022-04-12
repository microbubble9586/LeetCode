package lcof;

import java.util.HashMap;
import java.util.Map;

public class Offer03 {
    public static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            if (map.containsKey(num)){
               res = num;
               break;
            }
            map.put(num,num);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2,3,0,1,2,5,3}));
    }
}
