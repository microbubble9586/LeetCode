package y2022.m06.d07;

public class Solution_875_M {
    public int minEatingSpeed(int[] piles, int h) {
        int l =0,r= ((int) 1e9);
        while (l<r){
            int mid = l+r>>1;
            if (check(piles,mid,h)){
                r = mid;
            } else {
                l=mid+1;
            }
        }
        return r;
    }

    private boolean check(int[] piles, int k, int h) {
        int ans =0;
        for (int pile : piles) {
            ans += Math.ceil(pile*1.0/k);
        }
        return ans<=h;
    }

    public static void main(String[] args) {
        Solution_875_M solution = new Solution_875_M();
        int[] piles = new int[]{30,11,23,4,20};
        int a = 1;
        double b = 0.5;
        a  += b;
//        System.out.println(a);
        System.out.println(solution.minEatingSpeed(piles, 5));
    }
}
