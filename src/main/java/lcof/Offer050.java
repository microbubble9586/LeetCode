package lcof;

import java.util.HashMap;
import java.util.Map;

public class Offer050 {
    /**
    *在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     */
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            } else {
                map.replace(chars[i],2);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(chars[i])==1){
                return chars[i];
            }
        }
        return ' ';
        /*for (int i = 0; i < n; i++) {
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            } else {
                //已经有值的情况下，控制键值等于2，后续如需求其他，可改变键的值自增
                map.replace(s.charAt(i),2);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';*/
    }
}
