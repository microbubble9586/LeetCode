package y2022.m04.d03;

public class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        int l=0,r=length-1;
        while (l < r) {
            int mid = (l+r)>>1;
            if (letters[mid]>target){
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return letters[r]>target?letters[r]:letters[0];
    }

    public static void main(String[] args) {
        nextGreatestLetter(new char[]{'b','c','c','f','j'}, 'a');
    }
}
