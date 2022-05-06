package y2022.m05.d04;

public class Solution_1823 {
    public int findTheWinner(int n, int k) {
        int pos = 0;
        for (int i = 2; i < n + 1; ++i) {
            pos = (pos + k) % i;
        }
        return pos + 1;
    }
}
