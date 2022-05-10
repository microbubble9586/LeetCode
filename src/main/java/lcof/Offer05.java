package lcof;

public class Offer05 {
    public String replaceSpace(String s) {
        //  StringBuilder res = new StringBuilder();
        // for(Character c : s.toCharArray())
        // {
        //     if(c == ' ') res.append("%20");
        //     else res.append(c);
        // }
        // return res.toString();
        return s.replace(" ","%20");
    }
}
