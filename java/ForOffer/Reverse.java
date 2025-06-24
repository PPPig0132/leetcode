package ForOffer;
/*给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。*/
public class Reverse {
    public int reverse(int x) {
        int ans=0;
      
        while(x!=0){
            int cur=x%10;
            ans=ans*10+cur;
            if (ans>214748364 || (ans==214748364 && cur>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (ans<-214748364 || (ans==-214748364 && cur<-8)) {
                return 0;
            }
            x=x/10;
        }
        //ans=ans*c;
        //if( ans>=((1<<31)-1) || ans<=-((1<<31)) ) return 0;
        return ans;
        
    }
    public static void main(String[] args) {
        Reverse re = new Reverse();
        int result = re.reverse(123);
        System.out.println(result); // 输出: 321

        result = re.reverse(-123);
        System.out.println(result); // 输出: -321

        result = re.reverse(1534236469);
        System.out.println(result); // 输出: 0 (因为反转后超出32位整数范围)
    }
    
}
