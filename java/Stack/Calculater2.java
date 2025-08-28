package Stack;
import java.util.*;
public class Calculater2 {
    public int calculate(String s) {
        Deque<Character> ops=new LinkedList<>();
        Deque<Integer> nums=new LinkedList<>();
        int cur,a;
        for(int i=0;i<s.length();){
            char c=s.charAt(i);
            cur=0;
            switch(c){
                case ' ':
                    ++i;
                    continue;
                case '+': ops.push(c);++i;break;
                case '-': ops.push(c);++i;break;
                case '*': 
                    a=nums.pop();
                    //cur=c-'0';
                    i++;
                    while(i<s.length()){
                       if(s.charAt(i)==' '){
                            ++i;
                            continue;
                        }
                        if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                            cur=cur*10+s.charAt(i)-'0';
                            ++i;
                        }
                        else{
                            break;
                        }
                    }
                    nums.push(a*cur);break;
                case '/':
                    a=nums.pop();
                    ++i;
                    //cur=c-'0';
                    while(i<s.length()){
                        if(s.charAt(i)==' '){
                            ++i;
                            continue;
                        }
                        if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                            cur=cur*10+s.charAt(i)-'0';
                            ++i;
                        }
                        else{
                            break;
                        }
                    }
                    nums.push(a/cur);break;
                default:
                    cur=c-'0';
                    ++i;
                    while(i<s.length()){
                        if(s.charAt(i)==' '){
                            ++i;
                            continue;
                        }
                        if(s.charAt(i)<='9' && s.charAt(i)>='0'){
                            cur=cur*10+s.charAt(i)-'0';
                            ++i;
                        }
                        else{
                            break;
                        }
                        
                    }
                    nums.push(cur);
                    break;

            }
        }
        char[] operators = new char[ops.size()];
        int [] numbers = new int[nums.size()];
        for(int i=0;i<operators.length;++i){
            operators[i]=ops.pop();
            numbers[i]=nums.pop();
        }
        cur=nums.pop();
        for(int i=0;i<operators.length;++i){
            char c=operators[i];
            if(c=='+'){
                cur+=numbers[i];
            }
            else{
                cur-=numbers[i];
            }
        }
        
        return cur;
    }
    public static void main(String[] args) {
        Calculater2 calculator = new Calculater2();
        String expression = "3+5 / 2";
        int result = calculator.calculate(expression);
        System.out.println("Result: " + result); // Output: Result: 10
    }
}

