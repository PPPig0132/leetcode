package BinSearch;
/*给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。*/

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[l]>nums[l+1]){
                return l;
            }
            if(nums[r]>nums[r-1]){
                return r;
            }
            if(nums[mid]>nums[mid+1]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
        
    }
    public static void main(String[] args) {
        // 调用 findPeakElement 方法
        int nums[] = {1,2,1,3,5,6,4};
        FindPeakElement findPeak = new FindPeakElement();
        System.out.println(findPeak.findPeakElement(nums)); // 输出 2
    }
    
}
