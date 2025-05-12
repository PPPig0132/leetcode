package RollWindow;
/*
返回数组中和大于等于target的连续子串长度，不存在满足条件的则返回0
*/
public class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length,start=0,end=1,sum=nums[0],ans=n+1;
        if(sum>=target){
            return 1;
        }
        // while(end<=n){
        //     if(sum>=target){
        //         ans=Math.min(ans,end-start);
        //         sum-=nums[start];
        //         start++;
        //     }
        //     else{
        //         sum+=nums[end];
        //         end++;
        //     }
        // }
        while(end<n){

            while(sum<target){
                sum+=nums[end];
                end++;
            }
            
            while(sum>=target && start<end){
                ans=Math.min(ans,end-start);
                sum-=nums[start];
                start++;
            }
        }
        if(ans==n+1){
            return 0;
        }
        else{
            return ans;
        }
    }
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen=new MinSubArrayLen();
        int []nums={2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen.minSubArrayLen(target, nums));
    }
}
