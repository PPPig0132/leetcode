package dp;
import java.util.*;
/*
idea:
和之前的dp一样，通过n个数组看每个子字符串是否可以分解
对于长度为n的子字符串，看当前子字符串去除任一字典中的单词后还能否被分解
*/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean ans[]=new boolean[s.length()+1];
        ans[0]=true;
        for(int i=1;i<=s.length();++i){
            String subs=s.substring(0,i);
            for(String word: wordDict){
                int n=word.length();
                if(i-n>=0){
                    if(match1(subs,word)&& ans[i]==false){//有一个成功就能成功，后续不再修改结果
                        ans[i]=ans[i-n];
                    }
                }
                // else{//boolean数组的默认值是false
                //     ans[i]=false;
                // }
                
                
            }
        }


        return ans[s.length()];
        
    }

    public  boolean match(String s,String subs){
        if(s.length()<subs.length()){
            return false;
        }
        for(int i=0;i<subs.length();++i){
            if(s.charAt(i)!=subs.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public  boolean match1(String s,String subs){
        if(s.length()<subs.length()){
            return false;
        }
        int n=s.length()-subs.length();
        for(int i=0;i<subs.length();++i){
            if(s.charAt(n+i)!=subs.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        String s = "dogs";
        List<String> wordDict = Arrays.asList("dog","s","gs","bbbb");
        System.out.println(solution.wordBreak(s, wordDict)); // Output: true
        // System.out.println(s.substring(0,1));
    }
}
