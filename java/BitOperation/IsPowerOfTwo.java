package BitOperation;
/*给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        // while(n!=1){
        //     if((n&1)==1) return false;//通过与数字最后一位进行 与 操作 判断数字的奇偶性
        //     n=(n>>1);
        // }
        return (n&(n-1))==0;
    }
    public static void main(String[] args) {
        IsPowerOfTwo ipt = new IsPowerOfTwo();
        System.out.println(ipt.isPowerOfTwo(1)); // 输出: true (2^0)
        System.out.println(ipt.isPowerOfTwo(2)); // 输出: true (2^1)
        System.out.println(ipt.isPowerOfTwo(3)); // 输出: false
        System.out.println(ipt.isPowerOfTwo(4)); // 输出: true (2^2)
        System.out.println(ipt.isPowerOfTwo(5)); // 输出: false
        System.out.println(ipt.isPowerOfTwo(16)); // 输出: true (2^4)
        System.out.println(ipt.isPowerOfTwo(-2)); // 输出: false
    }
}
