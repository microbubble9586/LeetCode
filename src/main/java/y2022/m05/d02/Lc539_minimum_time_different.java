package y2022.m05.d02;

import java.util.List;

public class Lc539_minimum_time_different {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        if (n > 1440) {
            return 0;
        }
        int[] minutes = new int[1440 * 2 + 10];
        for (String s : timePoints) {
            //此处输入一定是标准输入，所以不存在可能的空指针情况，因此不做额外的判空处理
            String[] ss = s.split(":");
            int h = Integer.parseInt(ss[0]);
            int m = Integer.parseInt(ss[1]);
            minutes[h * 60 + m]++;
            minutes[h * 60 + m + 1440]++;
        }
        int ans = 1440, last = -1;
        for (int i = 0; i < 1440 * 2; i++) {
            if (minutes[i] == 0) {
                continue;
            }
            if (minutes[i] > 1) {
                ans = 0;
                break;
            } else if (last != -1) {
                ans = Math.min(ans, i - last);
            }
            last = i;
        }

        return ans;
    }
}
