package BackTrack;
import java.util.*;

public class Perrmute {
    public static void main(String args[]){
        int[] nums={1,2,3};
        Perrmute obj=new Perrmute();
        List<List<Integer>> ans=obj.permute(nums);
        for(List<Integer> list:ans){
            System.out.println(list);
        }

    }
     public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();

        backtrack(0,nums.length,nums,ans);
        return ans;

        
    }

    public void backtrack(int start,int end,int[] nums,List<List<Integer>>ans ){
        if(start==end){
            List<Integer>res=new ArrayList<Integer>();
            for(int num:nums){
                res.add(num);
            }
            ans.add(res);
            return;
        }
        for(int i =start;i<end;++i){
            int temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;

            backtrack(start+1,end,nums,ans);

            temp=nums[i];
            nums[i]=nums[start];
            nums[start]=temp;
        }
    }
    
}