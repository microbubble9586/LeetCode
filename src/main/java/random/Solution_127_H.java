package random;

import java.util.*;

public class Solution_127_H {
     String bw, ew;
     Set<String> set = new HashSet();

    public  int ladderLength(String beginWord, String endWord, List<String> wordList) {
        bw = beginWord;
        ew = endWord;
        for (String word : wordList) {
            set.add(word);
        }
        if (!set.contains(ew)) {
            //测试是否满足这种情况
            return -100;
        }
        int ans = bfs();
        return ans == -1 ? 0 : ans+1;
    }

    public  int bfs() {
        Deque<String> dq1 = new ArrayDeque<>();
        Deque<String> dq2 = new ArrayDeque<>();
        Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();

        dq1.add(bw);
        map1.put(bw, 0);
        dq2.add(ew);
        map2.put(ew, 0);
        while (!dq1.isEmpty() && !dq2.isEmpty()) {
            int t = -1;
            if (dq1.size() <= dq2.size()) {
                t = update(dq1, map1, map2);
            } else {
                t = update(dq2, map2, map1);
            }
            if (t != -1) {
                return t;
            }
        }
        return -1;
    }

    private  int update(Deque<String> dq, Map<String, Integer> curMap, Map<String, Integer> otherMap) {
        int m = dq.size();
        while (m-- > 0) {
            String cur = dq.pollFirst();
            for (int i = 0; i < cur.length(); i++) {
                for (int j = 0; j <= 25; j++) {
                    String sub = cur.substring(0, i) + String.valueOf((char) ('a' + j)) + cur.substring(i + 1);
                    if (set.contains(sub)) {
                        Integer a1 = curMap.get(sub);
                        Integer a2 = (curMap.get(cur) + 1);
                        if (curMap.containsKey(sub) && (a1 <= a2)) {
                            continue;
                        }
                        if (otherMap.containsKey(sub)) {
                            return curMap.get(cur) + 1 + otherMap.get(sub);
                        } else {
                            dq.addLast(sub);
                            curMap.put(sub, curMap.get(cur) + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(ladderLength("hit", "cog", new ArrayList<>() {
//            {
//                add("hot");
//                add("dot");
//                add("dog");
//                add("lot");
//                add("log");
//                add("cog");
//            }
//        }));
    }
}
