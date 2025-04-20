package dp;

/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度
idea
1.记录每个数前面比他小的数的个数（这些比他小的数都是有序的吗？）
2.找到前一个最大值比当前值小且最长的递增数列
使用单调列表来存储各个最小值的index
*/

public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int ans[]=new int[nums.length+1];
        int res=1;
        ans[0]=1;
        int min=nums[0];
        for(int i=1;i<nums.length;++i){
            if(nums[i]<=min){
                ans[i]=1;
            }
            int max=0;
            for(int j=i-1;j>=0;--j){
                if(nums[i]>nums[j]){
                    max=Math.max(max,ans[j]);
                }
            }
            ans[i]=max+1;
            res=Math.max(res,ans[i]);
        }
        return res;
        
    }
    public static void main(String[] args) {
        LengthOfLIS solution = new LengthOfLIS();
        int nums1[]={1,3,6,7,9,4,10,5,6};
        int nums[]={0};
        System.out.println(solution.lengthOfLIS(nums)); // Output: 4 (The longest increasing subsequence is [2,3,7,101], therefore the length is 4.)
    }
    
}
