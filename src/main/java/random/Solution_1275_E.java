package random;

public class Solution_1275_E {
    public String tictactoe(int[][] moves ){
        int a=0,b=0,n=moves.length;
        int[] ac = new int[]{7,56,448,73,146,292,273,84};
        for (int i = 0; i < n; i++) {
            if ((i&1)==1){
                b^=1<<(3*moves[i][0]+moves[i][1]);
            } else {
                a^=1<<(3*moves[i][0]+moves[i][1]);
            }
        }
        for (int i : ac) {
            if ((a&i)==i){
                return "A";
            }
            if ((b&i)==i){
                return "B";

            }
        }
        return n==9?"Draw":"Pending";
    }

}
