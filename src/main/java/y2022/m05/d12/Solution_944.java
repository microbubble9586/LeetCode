package y2022.m05.d12;

import java.util.ArrayList;
import java.util.List;

public class Solution_944 {

    public static int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int ans =0;
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < m; i++) {

            char f = strs[0].charAt(i);
            for (int j = 0; j < n; j++) {
                if (strs[j].charAt(i) < f && !columns.contains(i)) {
                    ans++;
                    columns.add(i);
                }
                f = strs[j].charAt(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        minDeletionSize(new String[]{"cba","daf","ghi"});
    }
}
