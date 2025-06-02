package BitOperation;
import java.util.*;
public class AddBinary {
    public String addBinary(String a, String b) {
        int m=a.length(),n=b.length();
        if(m<n){//保证b是较短的字符串
            return addBinary(b,a);
        }
        char ac[]=a.toCharArray(),bc[]=b.toCharArray();
        char []ans=new char[ac.length+1];
        ans[0]='1';
        int mark=0;
        for(int i=1;i<=n;++i){
            int a1=ac[m-i]-'0', a2=bc[n-i]-'0',sum=a1+a2+mark;
            mark=sum/2;
            ans[m+1-i]=sum%2==0?'0':'1';
        }
        int cur=m-n-1;
        while(cur>=0){
            if(mark!=0){
                int a1=ac[cur]-'0',sum=a1+mark;
                mark=sum/2;
                ans[cur+1]=sum%2==0?'0':'1';
                cur--;
            }
            else{
                ans[cur+1]=ac[cur--];
            }
        }
        if(mark==1){
            return new String(ans);
        }
        return new String(ans,1,ans.length-1); // 返回结果时去掉首位的'1'
    }
    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        String a = "11";
        String b = "1";
        System.out.println(solution.addBinary(a, b)); // Output: "10111" (The sum of 10 and 13 in binary is 11101.)
    }
}
