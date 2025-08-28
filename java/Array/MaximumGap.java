package Array;
import java.util.*;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        int n=nums.length,ans=0,start=0;
        if(n==2) return Math.abs(nums[0]-nums[1]);//排除一个桶的情况
        int max=Arrays.stream(nums)
                        .max()
                        .orElseThrow(() -> new IllegalArgumentException("数组为空"));;
        int min=Arrays.stream(nums).min().orElseThrow(() -> new IllegalArgumentException("数组为空"));;
        int l=(max-min)/(n-1)+1;
        int record[]=new int[2*n-2];//{min,max}*(n-1)
        int []count=new int[n-1];
        for(int num:nums){
            int idx=(num-min)/l;
            if(count[idx]==0){
                record[2*idx]=num;
                record[2*idx+1]=num;
            }
            else{
                record[2*idx]=Math.min(record[2*idx],num);
                record[2*idx+1]=Math.max(record[2*idx+1],num);
            }
            count[idx]++;
        }
        for(int i=1;i<n-1;++i){
            if(count[i]==0) continue;
            ans=Math.max(record[2*i]-record[2*start+1],ans);
            start=i;
        }
        return ans;
    }
    public static void main(String[] args) {
        MaximumGap mg = new MaximumGap();
        int[] nums = {1,100000,3};
        System.out.println("Maximum Gap: " + mg.maximumGap(nums)); // Output: 3
    }
}
