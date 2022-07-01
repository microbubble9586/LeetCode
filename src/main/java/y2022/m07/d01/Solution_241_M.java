package y2022.m07.d01;

import java.util.ArrayList;
import java.util.List;

public class Solution_241_M {
    char[] cs ;
    public List<Integer> diffWaysToCompute(String expression) {
        cs = expression.toCharArray();
        return dfs(0,cs.length-1);
    }

    private List<Integer> dfs(int l ,int r){
        List<Integer> ans = new ArrayList<>();
        for(int i = l;i<= r;i++){
            if(cs[i]>='0'&&cs[i]<='9'){
                continue;
            }
            List<Integer> list1 = dfs(l,i-1),list2 = dfs(i+1,r);
            for(Integer x :list1){
                for(Integer y : list2){
                    int cur = 0;
                    if(cs[i] =='+'){
                        cur = x+y;
                    } else if(cs[i] == '-'){
                        cur = x - y;
                    } else{
                        cur = x*y;
                    }
                    ans.add(cur);
                }
            }
        }
        if(ans.isEmpty()){
            int cur = 0;
            for(int i = l ;i<=r;i++){
                cur = cur*10 + (cs[i]-'0');
            }
            ans.add(cur);
        }
        return ans;
    }
}
