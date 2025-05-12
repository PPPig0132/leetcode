package RollWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    // public List<Integer> findSubstring(String s, String[] words) {
    //     int m=s.length(),n=words.length,x=words[0].length();
    //     List<Integer>ans=new ArrayList<Integer>();

    //     if(m<n*x){
    //         return ans;
    //     }
    //     char s1[]=s.toCharArray();
    //     int start=0,end=n*x-1;
    //     while(end<m){
    //         if(check(s1,start,end,words)){
    //             ans.add(start);
    //         }
    //         start++;
    //         end++;
    //     }
    //     return ans;
    // }
     public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 遍历所有可能的起始位置
        for (int i = 0; i < wordLength; i++) {//以单词的每一个字符为起始位置
            Map<String, Integer> windowCount = new HashMap<>();
            int left = i, right = i;

            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordCount.containsKey(word)) {
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);

                    // 如果窗口内的单词超出限制，移动左边界
                    while (windowCount.get(word) > wordCount.get(word)) {//保证窗口中每个单词的数量小于等于words中每个单词的数量
                        String leftWord = s.substring(left, left + wordLength);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        left += wordLength;
                    }

                    // 如果窗口大小等于总长度，记录起始索引
                    if (right - left == totalLength) {//长度相等时窗口中的单词数量也相等
                        result.add(left);
                    }
                } else {
                    // 如果单词不在 words 中，重置窗口
                    windowCount.clear();
                    left = right;
                }
            }
        }

        return result;
    }

   
     public boolean match(char []s,int start, char []words){
        for(int i=0;i<words.length;++i){
            if(s[i+start]!=words[i])
            {
                return false;
            }
            
        }
        return true;
    }
    public static void main(String[] args) {
        FindSubstring findSubstring=new FindSubstring();
        String s="barfoothefoobarman";
        String []words={"foo","bar"};
        List<Integer>ans=findSubstring.findSubstring(s, words);
        for(int i=0;i<ans.size();++i){
            System.out.print(ans.get(i)+" ");
        }
        // System.out.println(findSubstring.findSubstring(s, words));
    }
}
