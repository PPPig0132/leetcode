package dp;

public class RobII {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) {
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int ans=dp(nums,0,nums.length-1);
        int ans1=dp(nums,1,nums.length);

        return ans>ans1?ans:ans1;
    }

    public int dp(int []nums,int start,int end){
        int ans[]=new int[nums.length-1];
        ans[0]=nums[start];
        ans[1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<end;++i){
            ans[i-start]=Math.max(ans[i-start-1],ans[i-start-2]+nums[i]);
        }
        return ans[ans.length-1];

    }
    public static void main(String[] args) {
        RobII robII = new RobII();
        int[] nums = {1,7, 9, 2};
        System.out.println("Maximum amount robbed: " + robII.rob(nums)); // Output: 3

        // nums = new int[]{1, 2, 3, 1};
        // System.out.println("Maximum amount robbed: " + robII.rob(nums)); // Output: 4

        // nums = new int[]{1, 2, 3};
        // System.out.println("Maximum amount robbed: " + robII.rob(nums)); // Output: 3
    }
}
