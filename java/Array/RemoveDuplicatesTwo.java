package Array;
/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
*/
public class RemoveDuplicatesTwo {
    // public int removeDuplicates(int[] nums) {
    //     int n=nums.length;
    //     if(n<3){
    //         return n;
    //     }
    //     int mark=nums[0]-1,count=1,pre=nums[0];
    //     for(int i=1;i<n;++i){
    //         if(nums[i]==pre){
    //             count++;
    //             if(count>2){
    //                 nums[i]=mark;
    //             }
    //         }
    //         else{
    //             count=1;
    //             pre=nums[i];
    //         }
    //     }
    //     count=0;
    //     for(int i=2;i+count<n;){
    //         if(nums[i]==mark){
    //             count++;
    //             if(i+count==n){
    //                 break;
    //             }
    //             nums[i]=nums[i+count];
    //         }
    //         else{
    //             ++i;
    //             if(i+count==n){
    //                 break;
    //             }
    //             nums[i]=nums[i+count];
    //         }
           
    //     }
    //     return n-count;
    // }
    public int removeDuplicates(int[] nums) {
        int left=2,right=2;
        while(right<nums.length&&left<=right){
            if(nums[left-2]!=nums[right]){
                nums[left]=nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
    public static void main(String[] args) {
        RemoveDuplicatesTwo solution = new RemoveDuplicatesTwo();
        int[] nums = {1,1,1,2,2,3};
        int newLength = solution.removeDuplicates(nums);
        System.out.println("New length: " + newLength); // Output: 5
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
}
