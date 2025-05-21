import java.util.Arrays;

public class Test {
        public int longestValidParentheses(String s) {
            if(s.length()==0||s.length()==1 ){
                return 0;
            }
            int n=s.length(),count=0;
            int []ans=new int[n+1];
            ans[0]=0;
    
            //数组实现栈
    
            int stack[]=new int[n];
            int top=-1;//栈顶指针
    
    
            for(int i=1;i<=n;++i){
                char c=s.charAt(i-1);
                if(c=='('){
                    if(count<=0){//前一段可以丢弃了,清空栈
                        top=-1;
                        stack[++top]=i;
                       count=1;
                    }
                    else{
                        count++;
                        stack[++top]=i;
                    }
                }
               else{
                count--;
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
        // Test solution = new Test();
        String s="Mmsdnajd",s1="md";
        int[][]in={{0,1},{2,4},{1,5},{4,5}};
        Arrays.sort(in,(a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        // for( int []item:in){
        //     for(int i=0;i<item.length;++i){
        //         System.out.print(item[i]+" ");
        //     }
        //     System.out.println();
        // }
        int ans[]=new int[]{1,3};
        String c="/home//foo/";
        String []c1=c.split("/");
        for(int i=0;i<c1.length;++i){
            System.out.print(c1[i]+" ");
        }
        // StringBuilder sb=new StringBuilder();
        // sb.append(1);
        // System.out.println(c.split(c)); // Output: 4 (The longest valid parentheses substring is "()()".)
    }
}
