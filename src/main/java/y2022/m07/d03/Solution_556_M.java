package y2022.m07.d03;

import java.util.ArrayList;
import java.util.List;


public class Solution_556_M {
    public static int nextGreaterElement(int nums) {
        List<Integer> list = new ArrayList<>();
        while (nums>0){
            list.add(nums%10);
            nums/=10;
        }
        System.out.println(list.toString());
        int n = list.size();
        int idx = -1;
        for (int i = 0; i < n-1 && idx ==-1; i++) {
            if (list.get(i+1)<list.get(i)){
                idx = i+1;
            }
        }
        if (idx ==-1){
            return -1;
        }
        for (int i = 0; i < idx; i++) {
            if (list.get(i)>list.get(idx)){
                swap(list,i,idx);
                break;
            }
        }
        // 9 8 5 4 8 8 8 7 2 1
        // 9 8 5 7 8 8 8 4 2 1
        // 9 8 5 7 1 2 4 8 8 8
        for (int l = 0,r=idx-1; l <r ; l++,r--) {
            swap(list,l,r);
        }
        //考虑超过int最大范围
        long ans = 0;
        for (int i = n-1; i >=0 ; i--) {
            ans = ans*10 + list.get(i);
        }

        return ans>Integer.MAX_VALUE?-1:(int)ans;
    }

    private static void swap(List<Integer> list, int idx1, int idx2) {
        Integer temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(6910));
    }
}
