package y2022.m06.d26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution_710_H {
    List<int[]> list = new ArrayList<>();

    int[] sum = new int[100010];
    int sz;
    Random random = new Random();


//    public Solution(int n, int[] blacklist) {
    public Solution_710_H(int n, int[] blacklist) {
        Arrays.sort(blacklist);
        int m = blacklist.length;
        if (m == 0) {
            list.add(new int[]{0, n - 1});
        } else {
            if (blacklist[0] != 0) {
                list.add(new int[]{0, blacklist[0] - 1});
            }
            for (int i = 1; i < m; i++) {
                if (blacklist[i - 1] == blacklist[i] - 1) {
                    continue;
                }
                list.add(new int[]{blacklist[i - 1] + 1, blacklist[i] - 1});
            }
            if (blacklist[m - 1] != n - 1) {
                list.add(new int[]{blacklist[m - 1] + 1, n - 1});
            }
        }
        sz = list.size();
        for (int i = 1; i <= sz; i++) {
            int[] info = list.get(i - 1);
            sum[i] = sum[i - 1] + info[1] - info[0] + 1;
        }

    }

    public int pick() {
        int x = random.nextInt(sum[sz]) + 1;
        int l = 1, r = sz;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int[] info = list.get(r - 1);
        int a = info[0], b = info[1], end = sum[r];
        return b - (end - x);
    }

    public static void main(String[] args) {
        Solution_710_H s = new Solution_710_H(7, new int[]{2, 3, 5});
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
        System.out.println(s.pick());
    }
}
