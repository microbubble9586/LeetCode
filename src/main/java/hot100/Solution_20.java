package hot100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution_20 {
    Map<Character,Character> map = new HashMap<>(){
        {put('(',')');put('{','}');put('[',']');}
    };
    public boolean isValid(String s) {
        //不为空且首字母为右括号，或者字符串长度为奇数不是有效的
        if (s.length()>0&& !map.containsKey(s.charAt(0))||s.length()%2==1){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c=='('||c=='['||c=='{'){
                // if (map.containsKey(c)) {
                //偷懒速度慢1ms
                stack.push(c);
                //stack.addLast(c);
            } else if(stack.isEmpty()||c!=map.get(stack.pop()/*stack.removeLast()*/)){
                return false;

            }
        }
        return stack.isEmpty();
    }
}
