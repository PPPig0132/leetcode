package Greedy;
import java.util.*;
/*
给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

0 <= j <= nums[i] 
i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。

idea:
1.从后往前跳：贪心，先找到最远能跳到最后一格的
2.从前往后跳：每次跳最远，找可到达范围内下次能跳最远(i+nums[i])的格子

当一个问题从前往后处理是贪心算法时，换一个顺序就会快很多
*/
public class Jump {
    //  public int jump(int[] nums) {
    //     int count=0;
    //     int terminal=nums.length-1;
    //     int min=terminal;
    //     while(terminal!=0){
    //         for(int i=terminal;i>=0;--i){
    //             if(nums[i]+i>=terminal){
    //                 min=i;
    //             }
    //         }
    //         terminal=min;
    //         count++;

    //     }
        
    //     return count;
        
    // }
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int count=0;
        int terminal=0,end=nums[terminal]+terminal,max=end;
        while(end<nums.length-1){
            for(int i=terminal+1;i<=end;++i){
                if(nums[i]+i>max){
                    max=nums[i]+i;
                    terminal=i;
                }
            }
            end=max;
            count++;
            max=0;
        }
        count++;//最后一跳
        return count;
        
    }
    public static void main(String args[]){
        int nums[]={4,1,1,3,1,1,1};
        int nums1[]={2,1,1,1,1};
        Jump obj=new Jump();
        System.out.println(obj.jump(nums));
    }
    
}
