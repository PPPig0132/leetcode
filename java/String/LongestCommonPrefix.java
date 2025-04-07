package String;
import java.util.*;
/*
 编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
 */

public class LongestCommonPrefix {
    public static void main(String args[]){
        String[] strs={"flower","flow","flight"};
        LongestCommonPrefix obj=new LongestCommonPrefix();
        String ans=obj.longestCommonPrefix(strs);
        System.out.println(ans);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return new String();
        }
        if( strs.length==1){
            return strs[0];
        }
        String ans=prefix(strs[0],strs[1]);
        for(int i=2;i<strs.length;i++){
            if(ans.length()==0){
                break;
            }
            ans=prefix(ans,strs[i]);
        }
        return ans;


        
    }
    // public String prefix(String p, String q){
    //     int m=Math.min(p.length(),q.length());
    //     if(m==0){
    //         return new String();
    //     }
    //     StringBuilder ans= new StringBuilder();
    //     int i=0;
    //     while(i<m && q.charAt(i)==p.charAt(i)){
    //         ans.append(p.charAt(i));
    //         i++;
    //     }
    //     return ans.toString();
        

    // }
    //使用substring直接返回字串会比新建StringBhuilder快
    public String prefix(String p, String q){
        int m=Math.min(p.length(),q.length());
        if(m==0){
            return new String();
        }
       
        int i=0;
        while(i<m && q.charAt(i)==p.charAt(i)){
            i++;
        }
        return p.substring(0,i);
        

    }
    
}
