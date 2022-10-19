package y2022.m10.d19;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnts = new int[2];
        for(int x : students){
            cnts[x]++;
        }
        for(int i = 0;i < sandwiches.length;i++){
            if(--cnts[sandwiches[i]]==-1){
                return sandwiches.length-i;
            }
        }
        return 0;
    }
}
