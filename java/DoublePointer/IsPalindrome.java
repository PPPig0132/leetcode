package DoublePointer;
/*
给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
s 仅由可打印的 ASCII 字符组成
*/
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char []s1=s.toCharArray();
        int a[]=new int[s1.length];
        int index=0;

        for(char c:s1){
            if('a'<=c && c<='z' ){
                a[index++]=c-'a';
            }
            else if('A'<=c && c<='Z' ){
                a[index++]=c-'A';
            }
            else if('0'<=c && c<='9' ){
                a[index++]=c-'\0';
            }
        }
        int l=0,r=index-1;
        while(l<r){
            if(a[l]!=a[r]){
                return false;
            }
            l++;
            r--;

        }
        return true;
    }
    public static void main(String[] args) {
        IsPalindrome isPalindrome=new IsPalindrome();
        String s="00";
        System.out.println(isPalindrome.isPalindrome(s)); //
    }
    
}
