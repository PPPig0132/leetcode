package BackTrack;
import java.util.*;
public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations lc = new LetterCombinations();
        System.out.println(lc.letterCombinations(digits));
    }
    public List<String> letterCombinations(String digits) {
        if (digits==null || digits.length()==0)
        {
            return(new ArrayList<String>()); 
        }
         String[] phoneMap = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> ans=new ArrayList<String>();
        backtrack(digits,0,phoneMap,new StringBuilder(),ans);
        return ans;
    }

    public void backtrack(String digits,int start,String[] phoneMap,StringBuilder cur,List<String> res){
        if(start==digits.length()){
            res.add(cur.toString());
            return;
        }
        String letters=phoneMap[digits.charAt(start)-'0'];

        for(char letter:letters.toCharArray()){
            cur.append(letter);
            backtrack(digits,start+1,phoneMap,cur,res);
            cur.deleteCharAt(cur.length()-1);
        }
    } 
    
}
