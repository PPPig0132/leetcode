package BackTrack;

import java.util.*;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans=new ArrayList<>();
        if(n<3 || n>55) return ans;
        backtrack(0, k, 1, n, ans, new ArrayList<>());
        return ans;
    }

    public void backtrack(int idx,int k,int num,int n,List<List<Integer>> ans,List<Integer> cur){
            if(idx==k){
                if(n==0){
                    ans.add(new ArrayList<>(cur));
                }
                return;
            }
            for(int i=num;i<10;++i){
                n-=i;
                if(n<0){
                    //n+=i;
                    return;
                }
                cur.add(i);
                backtrack(idx+1,k,i+1,n,ans,cur);
                n+=i;
                cur.remove(cur.size()-1);
            }
    }
    public static void main(String[] args) {
        CombinationSum3 cs3 = new CombinationSum3();
        int k = 3;
        int n = 7;
        List<List<Integer>> result = cs3.combinationSum3(k, n);
        System.out.println("Combination Sum 3 Result: " + result); // Output: [[1, 2, 4]]
        k = 3;
        n = 9;
        result = cs3.combinationSum3(k, n);
        System.out.println("Combination Sum 3 Result: " + result); // Output: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
    }
}
