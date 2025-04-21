package Greedy;
import java.util.*;
/*
1.
记录单调递增数列，可能获得的最大收益为数列尾减去数列头
min不变的情况下只需要更新max就行
min变小后，重新更新max和min

2.贪心算法：上帝视角倒着扫(opt*)
只需要更新最大值，每个位置的卖出收益等于当前最大值减去该点的价格
*/
public class MaxProfit {
    //  public int maxProfit(int[] prices) {
    //     int ans=0,min=prices[0],max=prices[0];
    //     for(int i=1;i<prices.length;i++){
    //         if(prices[i]>=max){
    //             max=prices[i];//更新递增数列的最大值
    //         }
    //         else if(prices[i]<min){//递增数列到头，计算当前的最大收益
    //             int profit=max-min;
    //             ans=Math.max(ans,profit);
    //             max=prices[i];
    //             min=prices[i];
    //         }
    //     }
    //     return Math.max(ans,max-min);
    // }

    public int maxProfit(int[] prices) {
        int ans=0,max=prices[prices.length-1];
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>=max){
                max=prices[i];//更新递增数列的最大值
            }
                int profit=max-prices[i];
                ans=Math.max(ans,profit);
             
        }
        return ans;
    }
    public static void main(String args[]){
        int prices[]={7,1,5,3,6,4};
        MaxProfit obj=new MaxProfit();
        System.out.println(obj.maxProfit(prices));
    }
    
}
