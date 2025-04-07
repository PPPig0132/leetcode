package String;
/*
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。
 */
import java.util.*;

public class IsValid {
    public static void main(String args[]){
        String s="()[]{}";
        IsValid obj=new IsValid();
        boolean ans=obj.isValid(s);
        System.out.println(ans);
    }

    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        if(s.length()%2==1){
            return false;
        }
        Deque<Character> stack=new LinkedList<Character>();
         /*优化：只有左括号需要进栈，右括号不需要进栈，只需要判断是否匹配 */
         
        // stack.push(s.charAt(0));
        // for(int i=1;i<s.length();i++){
        //     if(!stack.isEmpty() && match(stack.peekFirst(),s.charAt(i))){
        //         stack.pop();
        //     }
        //     else{
        //         stack.push(s.charAt(i));
        //     }
        // }
       
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char top=stack.pop();
                if(!match(top,c)){
                    return false;
                }
            }
        }
        return stack.isEmpty();

        
    }

    public boolean match(char p,char q){
        if(p=='(' && q==')'){
            return true;
        }
        if(p=='[' && q==']'){
            return true;
        }
        if(p=='{' && q=='}'){
            return true;
        }
        return false;

    }
    
}
