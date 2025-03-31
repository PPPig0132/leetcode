package BackTrack;
import java.util.*;

public class Subsets {
    public static void main(String args[]){
        int[] nums={1,2,3};
        Subsets obj=new Subsets();
        List<List<Integer>> ans=obj.subsets(nums);
        System.out.println(ans.size());
        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
     public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> ans=new ArrayList<List<Integer>>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        
         return ans;
        
    }

    public void backtrack(int[] nums,int start,List<Integer>cur,List<List<Integer>>res){
        res.add(new ArrayList<>(cur));
        for(int i=start;i<nums.length;++i){
            cur.add(nums[i]);
            backtrack(nums,i+1,cur,res);
            cur.remove(cur.size()-1);
        }
    } 
    
}
