package y2022.m04.d20.d21;

public class Solution {
    public static String toGoatLatin(String s) {
        String last = "a";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();) {
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            if ("aeiouAEIOU".indexOf(s.charAt(i)) > 0) {
                sb.append(s, i, j).append("ma");
            } else {
                sb.append(s.substring(i + 1, j)).append(s.charAt(i)).append("ma");
            }
            sb.append(last);
            last += "a";
            i = j + 1;
            if (i < s.length()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "";
    }
}
