import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9 {
    public static void main(String[] args) {

        int [] array = {2, 7, 11, 15};
        int target = 9;

        Solution9 solution = new Solution9();
        List<Integer> answer = solution.findAnagrams("abab", "ab");

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }


        System.out.println("The sum of the array is: ");

       
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>res=new ArrayList<>();
        if(s.length()<p.length()) return res;
        char [] q=p.toCharArray();
        Arrays.sort(q);
        int pre=0;
        for(;pre<s.length()-p.length()+1;pre++){
            int end=pre+p.length();
            String temp=s.substring(pre,end);
            char []temp1=temp.toCharArray();
            Arrays.sort(temp1);
            if(Arrays.equals(q,temp1)){
                res.add(pre);
            }
        }
        return res;

        
    }

   
}