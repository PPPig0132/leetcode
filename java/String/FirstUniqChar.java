package String;
import java.util.*;
//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
// s.toCharArray();
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        char[] c = s.toCharArray();
        for(char ch : c){
            count[ch - 'a']++;
        }
        //count[c[i] - 'a'] 代替hashmap
        for(int i = 0; i < c.length; i++){
            if(count[c[i] - 'a'] == 1){
                return i;
            }
        }
        
        return -1;
        
    }
    public static void main(String args[]){
        String s="lleetcode";
        FirstUniqChar obj=new FirstUniqChar();
        System.out.println(obj.firstUniqChar(s));
    }
    
}
