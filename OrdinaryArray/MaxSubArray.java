public class MaxSubArray {
    public static void main(String[] args) {
        // 调用 hello 方法
        int nums[] = {5,4,-1,7,8};
        MaxSubArray maxSub = new MaxSubArray();
        System.out.println(maxSub.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int right=0;
        int sum=0;
        int max=nums[right];
        while(right<nums.length){
            sum+=nums[right];
            right++;
            max=(sum>max)?sum:max;
            if(sum<0){
                sum=0;
            }
        }
        return max;
        
    }
}