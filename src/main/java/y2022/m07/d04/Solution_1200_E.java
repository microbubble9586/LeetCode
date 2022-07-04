package y2022.m07.d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_1200_E {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <n-1 ; i++) {
            int value = arr[i+1]-arr[i];
            List<Integer> eachList = new ArrayList<>();
            if (min>value){
                min = value;
                ans.clear();
                eachList.add(arr[i]);
                eachList.add(arr[i+1]);
                ans.add(eachList);
            } else  if (min == value){
                eachList.add(arr[i]);
                eachList.add(arr[i+1]);
                ans.add(eachList);
            }
        }
        return ans;
    }
}
