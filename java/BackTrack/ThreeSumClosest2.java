package BackTrack;

/*给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
返回这三个数的和。

非回溯实现*/
import java.util.*;
public class ThreeSumClosest2 {
   public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        if(n==3) return nums[0]+nums[1]+nums[2];
        int sum1=nums[0]+nums[1]+nums[2],sum2=nums[n-1]+nums[n-2]+nums[n-3];
        if(sum1>=target) return sum1;
        if(sum2<=target) return sum2;
        int ans=0;
        for (int i = 0; i < nums.length-2; i++) {
            int num=target-nums[i];
            int left=i+1;
            int right=nums.length-1;
            //优化点1 如果和下一个数一致，无需重复寻找
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //优化点2 如果等于直接返回
            // if (nums[i+1]+nums[i+2]==num){
            //     return target;
            // }

            //优化点3  只能跳过，因为还有=、还有大于场景
            int sum=nums[right]+nums[right-1];
            if (sum<num){
                if (num-sum<min){
                    min = num- sum;
                    ans=sum+nums[i];
                }
                continue;
            }

            while (left<right){
                sum=nums[left]+nums[right];
                if (sum>num){
                    if (sum-num<min){
                        min=sum-num;
                        ans=sum+nums[i];
                    }
                    right--;
                }else if (sum==num){
                    return target;
                }else {
                    if (num-sum<min){
                        min=num-sum;
                        ans=sum+nums[i];
                    }
                    left++;
                }
            }
        }
        return ans;
    }
     public static void main(String[] args) {
        ThreeSumClosest2 threeSumClosest = new ThreeSumClosest2();
        int[] nums = {-1,2,1,-4};
        int target = 1;

        int result = threeSumClosest.threeSumClosest(nums, target);
        System.out.println("The closest sum is: " + result);
    }
}