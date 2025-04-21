package Trick;
/*
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素

因为Majority元素数量总是大于一半，
*/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int ans=nums[0],count=1;
        for(int i=1;i<nums.length;++i){
            if(ans==nums[i]){
                    count++;
                }
            else{
                if(count==1){
                    ans=nums[i];
                }else{
                    count--;
                }
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] nums = {8,8,7,7,7};
        System.out.println(solution.majorityElement(nums)); // Output: 2 (The majority element is 2.)
    }
}
