package dp;
import java.util.*;

/*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 

idea:
Climp(n)=1+Climp(n-1)+Climp(n-2)   每次爬1阶或者2阶

从后往前计算，时间复杂度为O(2^N)
从前往后计算，时间复杂度为O(N)
*/


public class ClimbStairs {
    public int climbStairs(int n) {
        int fib[]=new int[n+1];
        fib[0]=1;fib[1]=1;
        for(int i=2;i<n+1;++i)
        {
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];
      
    }
    public static void main(String args[]){
        ClimbStairs obj=new ClimbStairs();
        System.out.println(obj.climbStairs(37));
    }
}
