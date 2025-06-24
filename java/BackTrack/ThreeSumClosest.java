package BackTrack;

/*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。*/

public class ThreeSumClosest {
    private int ans;
    private int flag=0;
    public int threeSumClosest(int[] nums, int target) {
        backtrack(nums,target,1,0,0);
        return ans;
        
    }
    public void backtrack(int []nums,int target,int cur,int i,int sum){
        while(i<nums.length && this.flag==0){
            if(cur>3) return;
            sum+=nums[i];
            if(cur==3){
                if(sum==target) {
                    this.ans=target;
                    this.flag=1;
                    return;
                }
                if(Math.abs(sum-target)<Math.abs(this.ans-target)) {
                    this.ans=sum;
                }
                //return;
            }
            backtrack(nums,target,cur+1,i+1,sum);
            sum-=nums[i];
            ++i;
        }
        
    }
    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {0,0,0};
        int target = 10000;
        threeSumClosest.ans = 30000; // 初始化为最大值
        int result = threeSumClosest.threeSumClosest(nums, target);
        System.out.println("The closest sum is: " + result);
    }
}
