package random.lc;

public class Solution_14_E {
    public String longestCommonPrefix(String[] strs) {

        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < str.length() && j < strs[i].length(); j++) {
                if (str.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
            }
            str = str.substring(0,j);
            if (str == ""){
                return str;
            }
        }
        return str;
    }
}
