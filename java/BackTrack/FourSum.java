package BackTrack;


import java.util.*;

public class FourSum {
    private List<List<Integer>> ans;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ans = new ArrayList<>();
        if(nums.length<4) return ans;
        int n=nums.length;
        Arrays.sort(nums);
        int sum1=nums[0]+nums[1]+nums[2]+nums[3];
        // if(sum1>target) return ans;
        // if(sum1==target) {
        //     List<Integer> temp = Arrays.asList(nums[0],nums[1],nums[2],nums[3]);
        //     ans.add(temp);
        //     return ans;
        // }
        // int sum2=nums[n-1]+nums[n-4]+nums[n-2]+nums[n-3];
        // if(target>sum2) return ans;
        // if(target==sum2)
        //  {
        //     List<Integer> temp = Arrays.asList(nums[n-4],nums[n-1],nums[n-2],nums[n-3]);
        //     ans.add(temp);
        //     return ans;
        // }
        backtrack(nums,target,0L,0,0,new ArrayList<>());

        return ans;
    }
    void backtrack(int []nums,int target,Long sum,int cur,int i,List<Integer>temp){
        if(cur==4){
            if(sum==target){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        while(i<nums.length){
            sum+=nums[i];
            temp.add(nums[i]);
            if(nums[i]>0 && sum>target){
                sum-=nums[i];
                temp.remove(temp.size()-1);
                return;
            }
            backtrack(nums,target,sum,cur+1,i+1,temp);
            sum-=nums[i];
            temp.remove(temp.size()-1);
            while(i<nums.length-1 &&nums[i]==nums[i+1]) ++i;
            ++i;
        }
    }
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {-1000000000,-1000000000,-1000000000,-1000000000};
        int target = 294967296;
        List<List<Integer>> result = fourSum.fourSum(nums, target);
        System.out.println("The four sum combinations are: " + result);
    }
}
