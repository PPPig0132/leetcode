package BackTrack;


import java.util.*;
//非回溯实现失败
public class FourSum2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length<4) return ans;
        int n=nums.length;
        Arrays.sort(nums);
        Long sum1=0L+nums[0]+nums[1]+nums[2]+nums[3];
        if(sum1>target) return ans;
        if(sum1==target) {
            List<Integer> temp = Arrays.asList(nums[0],nums[1],nums[2],nums[3]);
            ans.add(temp);
            return ans;
        }
        Long sum2=0L+nums[n-1]+nums[n-4]+nums[n-2]+nums[n-3];
        if(target>sum2) return ans;
        if(target==sum2)
         {
            List<Integer> temp = Arrays.asList(nums[n-4],nums[n-1],nums[n-2],nums[n-3]);
            ans.add(temp);
            return ans;
        }

        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;++j){
                int cur=target-nums[i]-nums[j];
                int l=j+1,r=n-1;
                if(nums[r]+nums[r-1] <cur) continue;
                while(l<r){
                    sum1=0L+nums[l]+nums[r];
                    if(sum1==cur){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[l],nums[r]);
                        ans.add(temp);
                        while(l<nums.length-1&&nums[l]==nums[l+1]) l++;
                        l++;
                        r--;
                    }
                    else if(sum1>cur){
                        r--;
                    }
                    else{
                        l++;
                    }
                }
                while(j<nums.length-1 &&nums[j]==nums[j+1]) j++;
            }
            while(i<nums.length-1&& nums[i]==nums[i+1]) i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        FourSum2 fourSum = new FourSum2();
        int[] nums = {-3,-3,-2,-2,-2,0,0,4};
        int target = -1;
        List<List<Integer>> result = fourSum.fourSum(nums, target);
        System.out.println("The four sum combinations are: " + result);
    }
}
