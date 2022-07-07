package y2022.m07.d07;

import java.util.Arrays;
import java.util.List;

public class Solution_648_M {
    static int N = 100000, M = 26;
    static int[][] tr = new int[N][M];
    static boolean[] isEnd = new boolean[N * M];
    static int idx;
    void add(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
        }
        isEnd[p] = true;
    }
    String query(String s) {
        for (int i = 0, p = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (tr[p][u] == 0) break;
            if (isEnd[tr[p][u]]) return s.substring(0, i + 1);
            p = tr[p][u];
        }
        return s;
    }
    public String replaceWords(List<String> ds, String s) {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(tr[i], 0);
            isEnd[i] = false;
        }
        for (String d : ds) add(d);
        StringBuilder sb = new StringBuilder();
        for (String str : s.split(" ")) sb.append(query(str)).append(" ");
        return sb.substring(0, sb.length() - 1);
    }
    //String[] ss = sentence.split(" ");
    //        for (int i = 0; i < ss.length; i++) {
    //            String cur = ss[i];
    //            for (int j = 1; j < cur.length(); j++) {
    //                String prefix = cur.substring(0, i);
    //                if (dictionary.contains(prefix)) {
    //                    ss[i] = prefix;
    //                    break;
    //                }
    //            }
    //        }
    //
    //
    //        StringBuilder sb = new StringBuilder();
    //        for (int i = 0; i < ss.length; i++) {
    //            sb.append(ss[i]);
    //            if (i != ss.length - 1) {
    //                sb.append(" ");
    //            }
    //        }
    //        return sb.toString();
}
