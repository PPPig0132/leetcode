package BitOperation;
/*
给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。

idea
按位与的结果只与 left 和 right 的二进制表示的公共前缀有关。
从最高位开始，只要 left 和 right 的某一位不同，那么从这一位开始，所有更低的位在按位与运算中都会变为0。
*/

public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int shift=0;
        while(left<right){//找公共前缀，当left=right时即为公共前缀
            left>>=1;
            right>>=1;
            shift++;
        }
        return left<<shift;
        
    }
    
}
