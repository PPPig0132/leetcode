package DoublePointer;
/*

给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

multiDP中的判断最长公共子串问题

idea:
将s中属于t的字母全部取出来组成新的字符串
使用数组统计t中每个字母是否出现，可以在O（n）内判断完成
*/

public class IsSubsequence {
     public boolean isSubsequence(String s, String t) {
        char t1[]=t.toCharArray(),s1[]=s.toCharArray();
        int index=0,m=s1.length,n=t1.length;
        if(m==0){
            return true;
        }
      
        for(int i=0;i<n;++i){
            if(t1[i]==s1[index]){
                index++;
            }
            if(index==m){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        IsSubsequence isSubsequence=new IsSubsequence();
        String s="abc",t="ahbgdc";
        System.out.println(isSubsequence.isSubsequence(s,t)); //true
    }
}
