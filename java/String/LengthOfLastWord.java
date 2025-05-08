package String;
import java.util.*;
/*
 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */

public class LengthOfLastWord {
     public int lengthOfLastWord(String s) {
        if(s.length()==0){
            return 0;
        }
        String s1=s.trim();
        int a=s1.length()-1,ans=0;
        while(a>=0 &&s1.charAt(a)!=' '){
            a--;
            ans++;
        }
        return ans;
        
    }
    public static void main(String args[]){
        String s="Hello World     ";
        String s1[]=s.split(" ");
        for(String str:s1){
            System.out.println(str);
        }
        LengthOfLastWord obj=new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord(s));
    }
    
}
