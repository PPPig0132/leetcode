package dp;
/*
给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积

idea:

maxProduct[i] = max(nums[i], maxProduct[i-1] * nums[i], minProduct[i-1] * nums[i])
minProduct[i] = min(nums[i], maxProduct[i-1] * nums[i], minProduct[i-1] * nums[i])

*/
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] maxProduct = new int[n];
        int[] minProduct = new int[n];
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        
        // int maxResult = nums[0];
        
        for (int i = 1; i < n; i++) {
            maxProduct[i] = Math.max(nums[i], Math.max(maxProduct[i-1] * nums[i], minProduct[i-1] * nums[i]));
            minProduct[i] = Math.min(nums[i], Math.min(maxProduct[i-1] * nums[i], minProduct[i-1] * nums[i]));
            
            //maxResult = Math.max(maxResult, maxProduct[i]);
        }
        int maxResult = Integer.MIN_VALUE;//最后统一遍历更快
        for(int i = 0; i < n; i++){
            maxResult = Math.max( maxResult,  maxProduct[i]);
        }
        
        return maxResult;
    }   
     public static void main(String[] args) {
        MaxProduct solution = new MaxProduct();
        int nums[]={2,-5,-2,-4,3};
        System.out.println(solution.maxProduct(nums)); // Output: 6 (The subarray [2,3] has the largest product 6.)
    }
}
