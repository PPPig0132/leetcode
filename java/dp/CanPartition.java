package dp;
/*
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

idea:
计算出当前数组的和，如果和为奇数，则返回false，和为偶数则看是否能找到和为sum/2的子数组(dp在于使用dp来判断前i个数列中是否存在合为sum/2的子数组)
设 dp[i][j] 表示在数组的前 i 个元素中，是否存在一个子集的和为 j。
对于每个 i 和 j，我们有两种选择：
不包含 nums[i-1]：dp[i][j] = dp[i-1][j]
包含 nums[i-1]：dp[i][j] = dp[i-1][j - nums[i-1]]
因此，dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i-1]]

给出两个桶，始终往小的加
*/

public class CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        if (sum % 2 != 0) {
            return false;
        }
        
        int n = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i][j] || dp[i-1][j - nums[i-1]];
                }
            }
        }
        
        return dp[n][target];
    }
    public static void main(String[] args) {
        CanPartition solution = new CanPartition();
        int nums[]={2,2,1,1};
        System.out.println(solution.canPartition(nums)); // Output: true (The array can be partitioned into [1, 5, 5] and [11].)
    }
   
    
}
