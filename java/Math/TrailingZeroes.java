package Math;
/*
给定一个整数 n ，返回 n! 结果中尾随零的数量。

idea:
5 10 15... +1
25 ...+2
125 ...+3

5的n次方就加1个0
*/

public class TrailingZeroes {
     public int trailingZeroes(int n) {
       int res=0,x=5;
       while(x<=n){
            res+=(n/x);
            x*=5;
       }
       return res;
        
    }
    
}