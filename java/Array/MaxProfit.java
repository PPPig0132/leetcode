package Array;
/*
给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

返回 你能获得的 最大 利润 。
*/


public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n=prices.length-1,max=prices[n],min=prices[n],ans=0;
        while(n>=0){
           
            if(prices[n]>min){
                ans+=max-prices[n+1];
                min=prices[n];
                max=prices[n--];
            }
            else if(prices[n]>max){
                max=prices[n--];
            }
            else if(n==0){
                ans+=max-prices[n--];
            }
            else{
                min=prices[n--];
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        MaxProfit solution = new MaxProfit();
        int[] prices = {2,4,1};
        int maxProfit = solution.maxProfit(prices);
        System.out.println("Max Profit: " + maxProfit); // Output: 5
    }
}
