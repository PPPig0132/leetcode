package Hash;
/*
给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个不同的索引 i 和 j ，
满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
*/
import java.util.*;
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<2){
            return false;
        }
        Set<Integer>set=new HashSet<Integer>();
        int kNumber [] =new int [k];
        for(int i=0;i<k;++i){
            if(i==nums.length){
                return false;
            }
            if(set.contains(nums[i])){
                return true;
            }
            kNumber[i]=nums[i];
            set.add(nums[i]);
        }
        
        for(int i=k;i<nums.length;++i){
            if(set.contains(nums[i])){
                    return true;
            }
            set.remove(kNumber[i%k]);
            set.add(nums[i]);
            kNumber[i%k]=nums[i];
        }
        return false;
    }


    public static void main(String[] args) {
        ContainsNearbyDuplicate solution = new ContainsNearbyDuplicate();
        int[] nums = {1,2,3,1};
        int k = 3;
        boolean result = solution.containsNearbyDuplicate(nums, k);
        System.out.println(result); // Output: true
    }
}
