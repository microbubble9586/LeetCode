package y2022.m07.d02;

import java.util.PriorityQueue;

public class Solution_871_H {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int n = stations.length;
        int idx = 0;
        int remain = startFuel,loc = 0,ans =0;
        while (loc<target){
            if (remain==0){
                if (!queue.isEmpty()&&++ans>=0){
                    remain += queue.poll();
                } else {
                    return  -1;
                }
            }
            loc += remain;
            remain = 0;
            while (idx<n&&stations[idx][0]<=loc){
                queue.add(stations[idx][1]);
                idx++;
            }
        }
        return ans;
    }
}
