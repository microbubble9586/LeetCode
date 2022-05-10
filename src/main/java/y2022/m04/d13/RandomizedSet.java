package y2022.m04.d13;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class RandomizedSet {
    static int[] nums = new int[200010];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int idx = -1;
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.remove(val);
        if (loc != idx) {
            map.put(nums[idx], loc);
        }
        nums[loc] = nums[idx--];
        return true;
    }
    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);
        randomizedSet.insert(4);
        randomizedSet.insert(5);
        randomizedSet.insert(6);
        randomizedSet.insert(171);
        randomizedSet.insert(12);
        randomizedSet.insert(1123);
        randomizedSet.insert(123);
        randomizedSet.insert(154);
        randomizedSet.insert(1123);
        randomizedSet.insert(451);
        randomizedSet.remove(171);
        randomizedSet.getRandom();
    }
}
