package Hash;
import java.util.*;
public class LongestConsecutive {
    // public int longestConsecutive(int[] nums) {
    //     Set<Integer>set=new HashSet<Integer>();
    //     int ans=1;
        
    //     for(int i=0;i<nums.length;++i){
    //         set.add(nums[i]);
    //     }
    //     for(int i=0;i<nums.length;++i){
    //         if(!set.contains(nums[i])){
    //             continue;
    //         }
    //         int a=nums[i],len=1;
    //         while(set.contains(a+1)){
    //             set.remove(a+1);
    //             len++;
    //             a++;
    //         }
    //         a=nums[i];
    //         while(set.contains(a-1)){
    //             set.remove(a-1);
    //             a--;
    //             len++;
    //         }
    //         ans=Math.max(ans,len);
    //     }
    //     return ans;
        
    // }
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])) continue;
            int left = hm.getOrDefault(nums[i]-1,0);
            int right = hm.getOrDefault(nums[i]+1,0);
            int range = 1 + left + right;
            hm.put(nums[i],range);
            hm.put(nums[i]-left,range);
            hm.put(nums[i]+right,range);
            max = Math.max(max,range);
        }
        return max;
    }
    public static void main(String[] args) {
        LongestConsecutive solution = new LongestConsecutive();
        int[] nums = {100,4,200,1,3,2};
        int result = solution.longestConsecutive(nums);
        System.out.println(result); // Output: 4
    }
}
