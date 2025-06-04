package Math;
/*
实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）
*/

public class MyPow {
    public double myPow(double x, int n) {
        double res = 1;
        long i = n; // 负数过小，转换成正数保存无效
        if(i < 0){
            i = -i;
            x = 1/x;
        }
        while(i > 0){
            if((i & 1) == 1){//判断奇偶数
                res = res * x;
            }
            x *= x;
            i /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double x = 2.0;
        int n = 10;
        double result = myPow.myPow(x, n);
        System.out.println(result); // Output: 1024.0
    }
    
}
