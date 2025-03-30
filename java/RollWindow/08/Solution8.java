import java.util.*;

public class Solution8 {
    public static void main(String[] args) {

        String s = "abcabcbb";

        Solution8 solution = new Solution8();
        int answer = solution.lengthOfLongestSubstring(s);


        System.out.println("The sum of the array is: "+answer);

       
    }
    public int lengthOfLongestSubstring(String s) {
        int max_len=0;
        List<Character> window=new ArrayList<Character>();
        Map<Character,Integer>hashtable=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            if(hashtable.containsKey(s.charAt(i))){
                max_len=(max_len>window.size())?max_len:window.size();
                int index=hashtable.get(s.charAt(i));

                for(int j=0;j<=index;j++){
                    hashtable.remove(window.get(0));
                    window.remove(0);
                }
                for (Character key : hashtable.keySet()) {
                     hashtable.put(key, hashtable.get(key) -index-1);
                    }
                window.add(s.charAt(i));
                hashtable.put(s.charAt(i),window.size()-1);
                
                
            }
            else{
                window.add(s.charAt(i));
                hashtable.put(s.charAt(i),window.size()-1);
            }
        }
        return (max_len>window.size())?max_len:window.size();
    
            
        }

   
}