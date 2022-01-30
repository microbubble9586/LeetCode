package y2022.m01.d30;

import java.util.*;

/**
 *
 * 两种方式，第一种耗时较长，第二种耗时较短，但是二者内存消耗都较大
 * @author chunpeng.ma
 * @version 1.0
 *
 * @date 2022/1/30 11:18
 */
public class Solution {

        public String[] uncommonFromSentences(String s1, String s2) {
            // Map<String, Integer> map = new HashMap<>();
            // String str = s1 + " " + s2;
            // String[] ss = str.split(" ");
            // for (String s : ss) map.put(s, map.getOrDefault(s, 0) + 1);
            // List<String> list = new ArrayList<>();
            // for (String s : map.keySet()) if (map.get(s) == 1) list.add(s);
            // return list.toArray(new String[list.size()]);
            String[] p1 = s1.split(" ");
            String[] p2 = s2.split(" ");
            Map<String, Integer> t1 = new HashMap<>();
            Map<String, Integer> t2 = new HashMap<>();
            Set<String> set = new HashSet<>();
            for(String s : p1){
                t1.put(s, t1.getOrDefault(s, 0)+1);
                set.add(s);
            }
            for(String s : p2){
                t2.put(s, t2.getOrDefault(s, 0)+1);
                set.add(s);
            }
            List<String> res = new ArrayList<>();
            for(String s : set){
                if((t1.getOrDefault(s, 0) == 1 && t2.getOrDefault(s, 0) == 0) ||
                        (t2.getOrDefault(s, 0) == 1 && t1.getOrDefault(s, 0) == 0)){
                    res.add(s);
                }
            }
            String[] ans = new String[res.size()];
            int i = 0;
            for(String s : res){
                ans[i++] = s;
            }
            return ans;
        }

}
