package y2022.m07.d13;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_735_M {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int t : asteroids){
            boolean ok = true;
            while(ok&&!q.isEmpty()&&q.peekLast()>0&&t<0){
                int a = q.peekLast(),b = -t;
                if(a<=b){
                    q.removeLast();
                }
                if(a>=b){
                    ok = false;
                }
            }
            if(ok){
                q.addLast(t);
            }
        }
        int n = q.size();
        int[] ans = new int[n];
        while(!q.isEmpty()) {
            ans[--n] = q.removeLast();
        }
        return ans;
    }
}
