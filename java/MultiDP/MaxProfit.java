package MultiDP;

/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

idea:
将整个数组的最大值与切分为两个子数组的最大值相比较

dp[i][j] 表示在第 i 天结束时，进行了 j 笔交易的最大利润。
hold[i][j] 表示在第 i 天结束时，进行了 j 笔交易并且持有股票的最大利润
not_hold[i][j] 表示在第 i 天结束时，进行了 j 笔交易并且不持有股票的最大利润。

hold[i][j] = max(hold[i-1][j], not_hold[i-1][j-1] - prices[i])
not_hold[i][j] = max(not_hold[i-1][j], hold[i-1][j] + prices[i])

最终答案是 not_hold[n-1][2]，其中 n 是数组 prices 的长度。


*/

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // 初始化状态变量
        int buy1 = Integer.MIN_VALUE; // 第一次买入后的最大利润（负值）
        int sell1 = 0;                // 第一次卖出后的最大利润
        int buy2 = Integer.MIN_VALUE; // 第二次买入后的最大利润（在第一次卖出后的基础上）
        int sell2 = 0;                // 第二次卖出后的最大利润

        for (int price : prices) {
            // 更新第一次买入后的最大利润
            buy1 = Math.max(buy1, -price);
            // 更新第一次卖出后的最大利润
            sell1 = Math.max(sell1, buy1 + price);
            // 更新第二次买入后的最大利润
            buy2 = Math.max(buy2, sell1 - price);
            // 更新第二次卖出后的最大利润
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
    
    public static void main(String[] args) {
        MaxProfit solution = new MaxProfit();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(solution.maxProfit(prices)); // Output: 6 (Buy on day 4 and sell on day 6, then buy on day 7 and sell on day 8)
    }
}
