package lcof;

public class Offer058 {
    public static String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        String s1 = s.substring(0, n);
        String s2 = s.substring(n, s.length() - 1);
        return sb.append(s2).append(s1).toString();
//        for (int i = n; i < chars.length ; i++) {
//            sb.append(chars[i]);
//        }
//        for (int i = 0; i <n ; i++) {
//            sb.append(chars[i]);
//        }
//        return sb.toString();
    }

    public static void main(String[] args) {
        reverseLeftWords("abcdefg",2);
    }
}
