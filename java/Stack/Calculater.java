package Stack;

import java.util.Stack;

/*
letcode 224
算术优先级： ()  +-   只有加减没有乘除
算术栈和符号栈
遇到乘除，先计算出结果
遇到加减和前括号，先进栈
遇到后括号，符号栈出栈至前括号完
*/

public class Calculater {
    // public int calculate(String s) {
    //     s=s.replaceAll(" ","");
    //     char s1[]=s.toCharArray();
    //     int []stack=new int[s1.length];
    //     char operator[]=new char[s1.length];
    //     int top1=-1,top2=-1,sum=0,a;
    //     for(int i=0;i<s1.length;++i){
    //         switch(s1[i]){
    //             case '+':
    //                 operator[++top2]=s1[i];
    //                 break;
    //             case '-':
    //                 operator[++top2]=s1[i];
    //                 if(i==0 || s1[i-1]=='('){
    //                     stack[++top1]=0;
    //                 }
    //                 //stack[++top1]=0;
    //                 break;
    //             case '(':
    //                 operator[++top2]=s1[i];
    //                 break;
    //             case ')':
    //                 while(operator[top2]!='('){
    //                     switch(operator[top2--]){
    //                         case '+':
    //                             a=stack[top1--];
    //                             stack[top1]+=a;
    //                             break;
    //                         case '-':
    //                             a=stack[top1--];
    //                             stack[top1]-=a;
    //                             break;
    //                     }
    //                 }
    //                 top2--;
    //                 break;
    //             default:
    //                 if(s1[i]=='0'){
    //                     stack[++top1]=0;
    //                     break;
    //                 }
    //                 sum=s1[i]-'0';
    //                 i++;
    //                 while(i<s1.length&&s1[i]-'0'>-1&&s1[i]-'0'<10){
    //                     sum=sum*10+(s1[i]-'0');
    //                     i++;
    //                 }
    //                 i--;
    //                 stack[++top1]=sum;
    //                 sum=0;
    //         }

    //     }
    //     int ans=stack[0],index=0;
    //     for(int i=0;i<=top2;++i){
    //         switch(operator[i]){
    //             case '+':
    //                 ans+=stack[++index];
    //                 break;
    //             case '-':
    //                 if(i==0 && top2==top1){
    //                     ans=0-ans;
    //                 }
    //                 else{
    //                     ans-=stack[++index];
    //                 }
    //                 break;
    //         }
    //     }
    //     // while(top1!=0){
    //     //     a=stack[top1--];
    //     //     stack[top1]+=a;
    //     // }
    //     return ans;
    // }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int result = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = (c == '+') ? 1 : -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
                num = 0;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); // Pop the sign
                result += stack.pop(); // Pop the previous result
            }
        }

        result += sign * num;
        return result;
    }
    public static void main(String[] args) {
        Calculater c=new Calculater();
        String s="1-(    -2)";
        // // System.out.println(c.calculate(s));
        // s="- (3 + (4 + 5))";
        // System.out.println(c.calculate(s));
        s="2-4-(8+2-6+(8+4-(1)+8-10))";
        System.out.println(c.calculate(s));
    }
}
