package Hash;
/*
类似与同构，判断字符串与单词组是否同构
使用hashmap数据结构

idea:将pattern中的每个字母与s中的每个单词相对应
*/
import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map =new HashMap<Character,String>();
        char p1[]=pattern.toCharArray();
        String []s1=s.split(" ");
        if(p1.length!=s1.length){
            return false;
        }
        for(int i=0;i<p1.length;++i){
            char c=p1[i];
            String word=s1[i];
            if(map.containsKey(c) ){
                if(!word.equals(map.get(c))){
                    return false;
                }
            }
            else if(map.containsValue(word)){
                return false;
            }
            else {
                map.put(c,word);
            }
            
        }
        return true;
        
    }
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        WordPattern wordPattern = new WordPattern();
        boolean result = wordPattern.wordPattern(pattern, s);
        System.out.println(result); // Output: true
    }
}
