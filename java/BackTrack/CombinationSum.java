package BackTrack;
import java.util.*;

public class CombinationSum {
    public static void main(String args[]){
        int[] candidates={2,3,6,7};
        int target=7;
        CombinationSum obj=new CombinationSum();
        List<List<Integer>> ans=obj.combinationSum(candidates,target);
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        backtrack(0,target,candidates,ans,new ArrayList<Integer>());
        return ans;
    }
   public void backtrack(int start,int target,int[] candidates,List<List<Integer>>ans,List<Integer> cur ){
        if(target==0){
            ans.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=start ; i<candidates.length;++i){
            if (candidates[i]>target){
                break;
            }
            cur.add(candidates[i]);
            backtrack(i,target-candidates[i],candidates,ans,cur);
            cur.remove(cur.size()-1);
        }
       
    }
    
}
