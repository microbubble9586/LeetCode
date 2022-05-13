package y2022.d13;

public class Solution_ms01_05 {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        if (Math.abs(m-n)>1){
            return false;
        }
        if (m-n<0){
            return oneEditAway(second,first);
        }
        int i=0,j=0,cnt=0;
        while (i<m&&j<n&&cnt<=1){
            if (first.charAt(i)==second.charAt(j)){
                i++;
                j++;
            } else {
                if (m==n){
                    i++;
                    j++;
                    cnt++;
                } else {
                    i++;
                    cnt++;
                }
            }
        }
        return cnt<=1;
    }

}
