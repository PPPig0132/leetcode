package MultiDP;
/*给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 */
public class MaxProfixK {
     public int maxProfit(int k, int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int []sells=new int[k];
        int buys[]=new int[k];
        for(int i=0;i<k;++i){
            buys[i]=-1001;
        }
       // buys[0]=-prices[0];
        for(int price :prices){
            for(int i=0;i<k;++i){
                if(i==0){
                    buys[i]=Math.max(buys[i],-price);
                    sells[i]=Math.max(sells[i],buys[i]+price);
                }
                else{
                    buys[i]=Math.max(buys[i],sells[i-1]-price);
                    sells[i]=Math.max(sells[i],buys[i]+price);
                }
            }
            
        }
        return sells[k-1];
        
    }
    public static void main(String[] args) {
        MaxProfixK solution = new MaxProfixK();
        int[] prices = {3,2,6,5,0,3};
        int k = 2;
        System.out.println(solution.maxProfit(k, prices)); // Output: 7 (Buy on day 2 and sell on day 3, then buy on day 4 and sell on day 5)
    }
    
}
