package Stack;
import java.util.*;
/*

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

idea:

三个栈 一个栈存数字 一个栈存单词 一个栈存中括号层数

遇到数字 数字进栈（数字栈）
单词开始： '['后方
单词结束：遇到数字或者']',每个单词结束时将单词和当前的cnt分别压入两个栈

遇到']': 弹出单词栈中的元素和数字栈中的元素 ，重复指定次数后和单词栈顶元素相结合再次压入

什么时候应该再次压入？
当下面只有一层括号没有出栈时？cs.size==stack.size的时候
  
 */

public class DecodeString {
    public String decodeString(String s) {
        Stack<StringBuilder>stack = new Stack<StringBuilder>();
        Stack <Integer> count=new Stack<Integer>();
        Stack<Character> cs=new Stack<Character>();

        StringBuilder ans=new StringBuilder();
        StringBuilder temp=new StringBuilder();
       
        int cnt=1;
        for(int i=0;i<s.length();i++){
            
            char c=s.charAt(i);
            if(i==s.length()-1 && c!=']'){
                temp.append(c);
                ans.append(temp);
                break;
            }
            if(isNumber(c)){
               
                int j=i;
                i++;
                while(s.charAt(i)!='['){
                    i++;
                }
                cnt=Integer.parseInt(s.substring(j, i));
                if(temp.length()>0&& !count.isEmpty()){
                    stack.push(new StringBuilder(temp));
                    temp.setLength(0);
                    count.push(cnt);
                }
                else if(temp.length()>0&& count.isEmpty()){
                    ans.append(temp);
                    temp.setLength(0);
                    count.push(cnt);
                }
                else{
                    count.push(cnt);
                }
                cs.push(s.charAt(i));
               
               
            }
        //    else if(c=='['){
                
        //    }
            else if(c==']'){
                if(temp.length()>0){
                    stack.push(new StringBuilder(temp));
                    temp.setLength(0);
                }
                cs.pop();
               
                
               if(cs.isEmpty()){
                while(!count.isEmpty()){
                    StringBuilder s1=new StringBuilder();
                    int x=count.pop();
                    StringBuilder top=stack.pop();
                    for(int k=0;k<x;k++){
                        s1.append(top);
                    }
                    if(!stack.isEmpty()){
                    top=stack.pop();
                    stack.push(top.append(s1));   
                    }
                    else{
                        stack.push(s1);
                    }
                }
                ans.append(stack.pop());
                }
                else{
                    StringBuilder s1=new StringBuilder();
                    int x=count.pop();
                    StringBuilder top=stack.pop();
                    for(int k=0;k<x;k++){
                        s1.append(top);
                    }
                    if(!stack.isEmpty() && cs.size()==stack.size()){
                    top=stack.pop();
                    stack.push(top.append(s1));   
                    }
                    else{
                        stack.push(s1);
                    }

                }

                
               
            }
            else{
                if(cs.size()==stack.size() && !stack.isEmpty() ){
                    StringBuilder top=stack.pop();
                    stack.push(top.append(c));
                }
                else{
                temp.append(c);
            }
            }

        }
        return ans.toString();
        
    }

    public boolean  isNumber(char c){
        return (c-'0')<9?true:false;
    }

    public static void main(String args[]){
        DecodeString obj=new DecodeString();
        String s="3[a2[c]]";
        String s1="abc3[cd]xyz";
        String s3="3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        String ans=obj.decodeString(s3);
        System.out.println(ans);
    }
    
}
