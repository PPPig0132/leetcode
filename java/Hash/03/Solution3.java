
import java.util.*;
import java.util.Arrays;
public class Solution3 {
    public static void main(String[] args) {

        int [] array = {1,0,1,2};
    
        int target = 9;

        Solution3 solution = new Solution3();
        int answer = solution.longestConsecutive(array);

    

        System.out.println("The sum of the array is: "+answer);
        // Arrays.sort(array);
        
       
    }

    // public int longestConsecutive(int[] nums) {
    //     if(nums.length==0){
    //         return 0;
    //     }
    //     Arrays.sort(nums);
    //     int max_len=1;
    //     int cur=1;
    //     Map<Integer,Integer> hashtable=new HashMap<Integer,Integer>();
    //     for(int i=0;i<nums.length;i++){
    //         if(hashtable.containsKey(nums[i]-1)){
    //             cur=hashtable.get(nums[i]-1)+1;
    //             hashtable.put(nums[i],cur);
    //             max_len=(cur>max_len)?cur:max_len;
    //         }
    //         // else if(hashtable.containsKey(nums[i]+1)){
    //         //     cur=hashtable.get(nums[i]+1)+1;
    //         //     hashtable.put(nums[i],cur);
    //         //     max_len=(cur>max_len)?cur:max_len;

    //         // }
    //         else{
    //             hashtable.put(nums[i],1);
    //         }
    //     }
    
    
            
        //     return max_len;
            
        // }
        public int longestConsecutive(int[] nums) {
            if(nums.length==0){
                return 0;
            }
            Arrays.sort(nums);
            // for (int i = 0; i < nums.length; i++) {
            //     System.out.println(nums[i]);
            // }
    
            int max_len=1;
            int cur=1;
          
            for(int i=0;i<nums.length-1;i++){
                if(nums[i+1]==nums[i]+1){
                    cur++;
                }
                else if(nums[i+1]==nums[i]){//处理有重复值的情况
                    continue;
                }
                else{
                    System.out.println("cur="+cur);
                    System.out.println("max_len="+max_len);
                    max_len=(cur>max_len)?cur:max_len;
                    cur=1;
                }
                
               
            }
        
        
            max_len=(cur>max_len)?cur:max_len;
                return max_len;
                
            }
    

}