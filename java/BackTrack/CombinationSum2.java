package BackTrack;

import java.util.*;
/*
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用 一次 。

注意：解集不能包含重复的组合。 
*/
public class CombinationSum2 {
    private List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backtrack(candidates,target,0,0,new ArrayList<>());
        return ans;
    }

    public void backtrack(int []candidates,int target,int sum,int cur,List<Integer>temp){
        while(cur<candidates.length){
            sum+=candidates[cur];
            temp.add(candidates[cur]);
            if(sum==target) {
                this.ans.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
                sum-=candidates[cur];
                return;
            }
            
            if(sum>target) {
                temp.remove(temp.size()-1);
                sum-=candidates[cur];
                return;
            }
            backtrack(candidates,target,sum,cur+1,temp);
            temp.remove(temp.size()-1);
            sum-=candidates[cur];
            
            while(cur+1<candidates.length&&candidates[cur]==candidates[cur+1] ) { //跳过重复元素
                cur++;
            }//跳过重复元素
            cur++;
        } 
       
    }
    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {5};
        Arrays.sort(candidates); // 排序以便跳过重复元素
        int target = 5;
        List<List<Integer>> result = combinationSum2.combinationSum2(candidates, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
