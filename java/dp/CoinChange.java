package dp;
import java.util.*;
/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。

idea:
优先拿面值最大的硬币 拿到不能拿  不能获得最优解(19,[5,3,1])

*/
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int ans[]=new int [amount+1];
       // Arrays.sort(coins);
       //不需要排序，对数组排序的时间开销大于顺序数组对算法的影响
        for(int j=0;j<coins.length;++j){
            System.out.print(coins[j]+" ");
        }
        ans[0]=0;
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; ++j) {
                
                if (i - coins[j] >= 0) { // 确保i - coins[j]是非负数
                    if (ans[i - coins[j]] != -1) { // 如果之前的状态是可达的
                        min = Math.min(min, ans[i - coins[j]]);
                    }
                    //min=ans[i-coins[j]]==-1?Integer.MAX_VALUE:Math.min(min,ans[i-coins[j]]);
                    //如果当前的值为-1是三元表达式会改变min的值，但是if条件句不会（三元表达式一定会写出else的条件if可以不接else，更适合这个场景）
                }
            }

        //对coins数组进行排序的算法
            // if(i<coins[0]){
            //     ans[i]=-1;
            //     continue;
            // }
            // int min=Integer.MAX_VALUE;
            // for(int j=0;j<coins.length;++j){
            //         if(i-coins[j]<0){
            //            break;
            //         }
            //         if (ans[i - coins[j]] != -1) { // 如果之前的状态是可达的
            //             min = Math.min(min, ans[i - coins[j]]);
            //         }
            //         //min=ans[i-coins[j]]==-1?Integer.MAX_VALUE:Math.min(min,ans[i-coins[j]]);
            //         //如果当前的值为-1是三元表达式会改变min的值，但是if条件句不会
                   
            // }
           if(min==Integer.MAX_VALUE){
            ans[i]=-1;
           }
           else{
            ans[i]=1+min;
           }
        }
        for(int j=0;j<coins.length;++j){
            System.out.print(ans[amount-coins[j]]+" ");
        }

        return ans[amount];
        
    }
    public static void main(String args[]){
        int coins[]={186,419,83,408};
        // Arrays.sort(coins);
        // for(int i=0;i<coins.length;i++){
        //     System.out.print(coins[i]+" ");
        // }
        int amount=6249;
        CoinChange obj=new CoinChange();
        System.out.println(obj.coinChange(coins,amount));
    }

    
}
