package String;
/*
使其能将字符串转换成一个 32 位有符号整数。超过32位整数的截断
*/

public class MyAtoi {
    public int myAtoi(String s) {
        s=s.trim();
        int c=1,ans=0;
        if(s.charAt(0)=='-') c=-1;
        else if(s.charAt(0)=='+') c=1;
        else if(s.charAt(0)-'0'>=0 && s.charAt(0)-'0'<=9) ans=s.charAt(0)-'0';
        else return ans;

        for(int i=1;i<s.length();++i){
            char c1=s.charAt(i);
            if(c1-'0'<0 || c1-'0'>9) return ans*c;
            if((c==-1)&&((ans>Integer.MAX_VALUE/10) || (ans==Integer.MAX_VALUE/10 && c1-'0'>=8))) {
                return Integer.MIN_VALUE;
            }
            else if((ans>Integer.MAX_VALUE/10) || (ans==Integer.MAX_VALUE/10 && c1-'0'>7)) {
                return Integer.MAX_VALUE;
            }
            else{
                ans=ans*10+(c1-'0');
            }
        }
        return ans*c;

    }
    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        //System.out.println(myAtoi.myAtoi("42")); // 输出: 42
        //System.out.println(myAtoi.myAtoi("   -42")); // 输出: -42
        //System.out.println(myAtoi.myAtoi("419 with words")); // 输出: 419
       // System.out.println(myAtoi.myAtoi("words and 987")); // 输出: 0
        System.out.println(myAtoi.myAtoi("-2147483648")); // 输出: -2147483648 (Integer.MIN_VALUE)
        //System.out.println(myAtoi.myAtoi("91283472332")); // 输出: 2147483647 (Integer.MAX_VALUE)
    }
}
