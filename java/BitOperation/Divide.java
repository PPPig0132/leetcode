package BitOperation;
//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
public class Divide {
    public int divide(int dividend, int divisor) {
        // 处理符号
        int sign = ((dividend > 0) ^ (divisor > 0)) ? -1 : 1;
        
        // 转换为正数
        long dividendAbs = Math.abs((long) dividend);
        long divisorAbs = Math.abs((long) divisor);
        
        // 初始化商
        long quotient = 0;
        
        // 位运算
        for (int i = 31; i >= 0; i--) {
            if ((dividendAbs >> i) - divisorAbs >= 0) {
                dividendAbs -= (divisorAbs << i);
                quotient += (1L << i);
            }
        }
        
        // 恢复符号
        quotient = sign * quotient;
        
        // 处理边界情况
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) quotient;
    }
}
