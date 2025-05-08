package Array;

/*
给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数
idea:
根据统计的数量计算后面元素前移的个数
*/

public class RemoveDuplicates {
    // public int removeDuplicates(int[] nums) {
    //     int n=nums.length,count=0,end=0;
    //     if(n==0||n==1){
    //         return n;
    //     }
    //     int i=1;
    //     while(i+count<n){
    //         if(nums[i]==nums[end]){
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
    //             end++;
    //         }
    //     }

    //     return n-count;
        
    // }
    public int removeDuplicates(int[] nums) {
        if(nums.length==0) {
			return 0;
		}
		
		int l=0;
		//数组有序，不用担心后面未遍历的数会与前面的重复，利用左指针计算数量
		for(int i=0;i<nums.length;i++) {
			
			if(nums[i]!=nums[l]) {
				l++;
				//将新出现的数值赋值到前面，遍历结束时数组前 l+1 个数据即为无重复新数组
				nums[l]=nums[i];
			}
			
		}
		
		return l+1;
		

	}
    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] nums = {1, 1};
        int newLength = solution.removeDuplicates(nums);
        System.out.println("New length: " + newLength); // Output: 4
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    
}
