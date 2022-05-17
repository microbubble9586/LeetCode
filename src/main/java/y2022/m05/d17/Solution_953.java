package y2022.m05.d17;

import java.util.Arrays;

public class Solution_953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dir = new int[26];
        for (int i = 0; i < 26; i++) {
            dir[order.charAt(i) - 'a'] = i;
        }
        String[] clone = words.clone();
        Arrays.sort(clone, (a, b) -> {
            int m = a.length();
            int n = b.length();
            int i = 0, j = 0;
            while (i < m && j < n) {
                int c1 = a.charAt(i) - 'a';
                int c2 = b.charAt(j) - 'a';
                if (c1 != c2) {
                    return dir[c1] - dir[c2];
                }
                i++;
                j++;
            }
            if (i < m) {
                return 1;
            }
            if (j < n) {
                return -1;
            }
            return  0;
        });
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (!clone[i].equals(words[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7,8,9};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
