package dp;
import java.util.*;
/*
给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
idea:
看第一个盒子装多少剩下的需要的盒子数最少
m=sqrt(n)  盒子数为m
ans[n]=1+min(ans[n-m*m],ans[n-(m-1)*(m-1)],ans[n-(m-2)*(m-2)]...ans[n-1*1]  
*/
public class NumSquares {
    public int numSquares(int n) {
        int res[]=new int [n+1];
        res[0]=0;
        res[1]=1;
        for(int i=2;i<=n;i++){
            int m=(int)Math.sqrt(i);
            int min=Integer.MAX_VALUE;
            while(m>0){
                min=Math.min(min,res[i-m*m]);
                m--;
                if(min<=1){//1是最小可以break的值
                    break;
                }
            }
            res[i]=1+min;
        }
        return res[n];
        
    }
    public static void main(String args[]){
        int n=12;
        NumSquares obj=new NumSquares();
        System.out.println(obj.numSquares(n));
    }
}
