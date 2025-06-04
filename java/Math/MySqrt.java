package Math;
/*
给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

逐步调大步长
0 1 2 4 8 16 ....

二分查找
*/

public class MySqrt {
     public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long left = 1;
        long right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int) right;
    }
    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        int x = 9801;
        int result = mySqrt.mySqrt(x);
        System.out.println(result); // Output: 3 (The square root of 15 is approximately 3.872, so the integer part is 3.)
    }
    
}