package String;
/*字符串相乘，结果也用字符串表示*/
public class Multiply {
    public String multiply(String num1, String num2) {
        if(zeroCheck(num1) || zeroCheck(num2)) return new String("0");
        int m=num1.length(),n=num2.length(),l=m+n;
        char res[]= new char[l];
        int cur=0,c,temp;
        for(int i=m-1;i>=0;--i){
            int m1=num1.charAt(i)-'0';
            c=0;
            for(int j=n-1;j>=0;--j){
                temp=res[l-(n-j)-cur] + (num2.charAt(j)-'0')*m1+c;//当前的值+乘积的值+进位符
                res[l-(n-j)-cur]= (char)(temp%10);
                c=temp/10;
            }
            if(c>0){
                res[l-n-cur-1]=(char)c;
            }
            cur++;
        }
        StringBuilder sb=new StringBuilder();
        int index=0;
        while(index<l && res[index]==0){
                index++;
            }
        for(int i=index;i<l;++i){
            res[i]+='0';
            sb.append(res[i]);
        }
        return sb.toString();
    }
    public boolean zeroCheck(String s){
        if(s.length()==1 && s.charAt(0)=='0') return true;
        return false;
    }
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        String num1 = "123";
        String num2 = "456";
        String result = multiply.multiply(num1, num2);
        System.out.println("The product of " + num1 + " and " + num2 + " is: " + result); // 输出: 56088
    }
}
