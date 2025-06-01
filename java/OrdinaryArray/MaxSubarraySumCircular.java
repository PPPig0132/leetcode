/*
1.最大子数组不跨越环形，也就是和普通数组一样的情况，这时候直接用Kadane算法得到最大值。
2.最大子数组跨越了环形，也就是包括数组的首尾部分。这时候，整个数组的总和减去最小子数组的和可能就是这种情况的最大值。
*/

public class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int right=0;
        int sum=0,minSum=0,total=0;
        int max=nums[right],min=nums[right];
        while(right<nums.length){

            sum+=nums[right];
            minSum+=nums[right];
            total+=nums[right];
            right++;
            max=(sum>max)?sum:max;
            min=(minSum<min)?minSum:min;
            if(sum<0){
                sum=0;
            }
            if(minSum>0){
                minSum=0;
            }
        }
        if(total==min){
            return max;
        }
        return Math.max(max,total-min);
    }
    public static void main(String[] args) {
        // 调用 maxSubarraySumCircular 方法
        int nums[] = {1,2,-2,3,2};
        MaxSubarraySumCircular maxSub = new MaxSubarraySumCircular();
        System.out.println(maxSub.maxSubarraySumCircular(nums));
    }
}
