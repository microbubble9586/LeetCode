package y2022.m06.d09;

import java.util.PriorityQueue;

public class Solution1 {
    public int minAbsoluteValue(int[] arr) {
        int l = 0, r = arr.length - 1;
        if (arr[0] >= 0) {
            return arr[0];
        }
        if (arr[r] <= 0) {
            return arr[r];
        }
        while (l <= r) {
            int mid = l + r >> 1;
            if (arr[mid] == 0) {
                return arr[mid];
            } else if (arr[mid] > 0) {
                if (arr[mid - 1] < 0) {
                    return Math.abs(arr[mid]) > Math.abs(arr[mid - 1]) ? arr[mid - 1] : arr[mid];
                }
                r = mid - 1;
            }else if (arr[mid] < 0) {

                l = mid + 1;

            }
        }
        return -1;
    }
    public int getMedianNum(int[] arr){
        //边界值
        if(arr == null || arr.length == 0){
            return -1;
        }

        //考虑到arr长度为1时交由下面业务逻辑处理耗时也耗空间，此处做提前判断时间复杂度也才多O(1)
        if(arr.length == 1){
            return  arr[0];
        }
        // 默认是小顶堆，大顶堆为new PriorityQueue<>(Collections.reverseOrder())
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        int length = arr.length;
        int k = length/2+1;

        for(int i = 0;i<k;i++){
            minPQ.add(arr[i]);
        }
        for(int i = k;i<length;i++){
            if(minPQ.peek() < arr[i]){
                minPQ.poll();
                minPQ.add(arr[i]);
            }
        }
        return minPQ.peek();
    }
    public int steps(int k){
        if (k==0){
            return 0;
        }
        if (k==1||k==2){
            return k==1?1:2;
        }
        int[] dp = new int[k+10];
        dp[1] =1;
        dp[2] =2;
        for (int i = 3; i <= k; i++) {
            dp[i] = dp[i-3]+dp[i-1];
        }
        return dp[k];
    }
}
