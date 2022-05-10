package y2022.m04.d12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//806
public class Solution {
    public static int[] numberOfLines(int[] widths, String s) {
        //需要行数，current row length
        int row=1,crl=0;
        for (char c : s.toCharArray()) {
            int l = widths[c-'a'];
            if(crl+l>100){
                row+=1;
                crl = l;
            } else {
                crl+=l;
            }
        }
        return new int[]{row,crl};

    }

    public static void main(String[] args) {
        int[] widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Arrays.toString(numberOfLines(widths, s)));
    }
}
