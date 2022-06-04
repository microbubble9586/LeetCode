package y2022.m06.d04;

import java.util.HashSet;
import java.util.Set;

public class Solution_929_E {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            int i =0 ;
            boolean noPlus = true;
            while (i<n){
                char c = s.charAt(i);
                if (c=='@'){
                    break;
                }
                //不加第二个条件会死循环
                if (c=='.'&&++i>=0){
                    //两种写法，一个写在判断条件中，一个写在下面
                    //i++;
                    continue;
                }
                if (c=='+'){
                    noPlus = false;
                }
                if (noPlus){
                    sb.append(c);
                }
                i++;
            }
            set.add(sb.append(s.substring(i)).toString());
        }
        return set.size();
    }
}
