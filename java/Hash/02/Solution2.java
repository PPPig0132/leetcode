import java.util.*;

public class Solution2 {
    public static void main(String[] args) {

        String [] array = {"eat","tea","tan","ate","nat","bat"};
        String [] array1 = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        String [] array2 = {"aac","bd"};
        String [] array3 = {"bdddddddddd","bbbbbbbbbbc"};

        Solution2 solution = new Solution2();

        List<List<String>> answer =solution.groupAnagrams(array);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }

        // System.out.println("The sum of the array is: " );

       
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList<>();
        }
        
        int index=0;//用于更新list中的index
        List<List<String>> ans = new ArrayList<>();
        // Map <String,Integer> hashtable=new HashMap<String,Integer>();

        // for(int i=0;i<strs.length;i++){
        //     String res=getId(strs[i]);
           
        //     System.out.println("res="+res);
        //     if(hashtable.containsKey(res)){
        //         ans.get(hashtable.get(res)).add(strs[i]);
        //     }
        //     else{
        //         List<String> temp=new ArrayList<>();
        //         temp.add(strs[i]);
        //         ans.add(temp);
        //     hashtable.put(res,index++);
        //     }

        // }



        return ans;
        
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int max_len=1;
        int cur=1;
      
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]==nums[i]+1){
                cur++;
            }
            else{
                max_len=(cur>max_len)?cur:max_len;
                cur=1;
            }
            
           
        }
    
    
            
            return max_len;
            
        }

   

}