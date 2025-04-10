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
        int ans=0;
        s=s.trim();
        int index=s.length()-1;
        while(s.charAt(index)!=' '){
            if(index==0){//整个字符串中只有一个单词的情况
                return ans+1;
             }
            ans++;
            index--;
          
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
