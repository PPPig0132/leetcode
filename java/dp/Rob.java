package dp;
import java.util.*;

/*
 * 
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 idea:
 在第n个点的最大值为 
 ans(n)=max(ans(n-1),nums[n]+ans(n-2))  即选当前的和选前一个
 */
public class Rob {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[]ans=new int[nums.length];
        ans[0]=nums[0];
        ans[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            ans[i]=Math.max(ans[i-1],ans[i-2]+nums[i]);
        }
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
       return ans[nums.length-1];
    }
    public static void main(String args[]){
        int nums[]={2,7,9,3,1};
        Rob obj=new Rob();
        System.out.println(obj.rob(nums));
    }
    
}
