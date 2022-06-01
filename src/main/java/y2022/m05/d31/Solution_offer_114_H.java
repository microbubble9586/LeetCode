package y2022.m05.d31;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_offer_114_H {
    int N = 26, M = N * N, idx = 0, cnt = 0;
    int[] he = new int[N], e = new int[M], ne = new int[M];
    int[] in = new int[N], out = new int[N];
    boolean[] vis = new boolean[N];

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx++;
        out[a]++;
        in[b]++;
    }

    public String alienOrder(String[] words) {
        int n = words.length;
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                if (!vis[c-'a'] && ++cnt >= 0) {
                    vis[c - 'a'] = true;
                }
            }
            for (int j = 0; j < i; j++) {
                if (!build(words[j], words[i])) {
                    return "";
                }
            }
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 26; i++) {
            if (vis[i] && in[i] == 0) {
                deque.addLast(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int u = deque.pollFirst();
            sb.append((char)(u + 'a'));
            for (int i = he[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--in[j] == 0) {
                    deque.addLast(j);
                }
            }
        }
        return sb.length() == cnt ? sb.toString() : "";

    }

    private boolean build(String a, String b) {
        int n = a.length();
        int m = b.length();
        int len = Math.min(n, m);
        for (int i = 0; i < len; i++) {
            int c1 = a.charAt(i) - 'a';
            int c2 = b.charAt(i) - 'a';
            if (c1 != c2) {
                add(c1, c2);
                return true;
            }
        }
        return n <= m;
    }
}
