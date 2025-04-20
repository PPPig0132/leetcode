package dp;

/*
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。


扫描到'('时当前index进栈
扫描到'）'配对的左括号index出栈
当前右括号组成的字符串的长度+右括号对应的左括号前的可用长度（ans[index-1]） 通过栈存储对应的左括号的index,通过数组实现栈

*/

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s.length()==0||s.length()==1 ){
            return 0;
        }
        int n=s.length();
        int []ans=new int[n+1];
        ans[0]=0;

        //数组实现栈

        int stack[]=new int[n];
        int top=-1;//栈顶指针


        for(int i=1;i<=n;++i){
            char c=s.charAt(i-1);
            if(c=='('){
               
                   
                    stack[++top]=i;
               
            }
           else{
            if(top>-1){
               //栈不空栈顶元素出栈、计算长度
               int x=stack[top--]-1;
               ans[i]=i-x+ans[x];
            }

            // else{
            //     ans[i]=0;
            // }
        }
    }
        int max=-1;
        for(int i=0;i<=n;++i){
            max=Math.max(ans[i],max);
        }
        return max;
    }
    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        String s = "(()(((()";
        System.out.println(solution.longestValidParentheses(s)); // Output: 4 (The longest valid parentheses substring is "(()))".)
    }
}
