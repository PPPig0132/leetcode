package Math;

public class IsUgly {
     public boolean isUgly(int n) {
        if(n<=0) return false;
        while(n%3==0) n = n/3;
        while(n%5==0) n = n/5;
        return (n & (n-1)) == 0;//把最右边的1改为0，如果结果为0，则说明只有2的因子
    }
}
