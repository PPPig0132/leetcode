public class FirstMissingPositive{
    public static void main(String[] args){
        int nums[] = {1,1};
        int nums1[] = {3,4,-1,1};
        int nums2[] = {7,8,9,11,12};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        int m=0;
        while(m<nums.length){
            if(nums[m]>0 && nums[m]!=m+1&& nums[m]<=nums.length && nums[m]!=nums[nums[m]-1]){
                int temp=nums[nums[m]-1];
                nums[nums[m]-1]=nums[m];
                nums[m]=temp;
    
            }
            else{
                m++;
            }
        }
    
        for(int i =0 ;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
            
        }
}