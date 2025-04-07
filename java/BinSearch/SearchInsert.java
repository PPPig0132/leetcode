package BinSearch;
import java.util.*;
/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

请必须使用时间复杂度为 O(log n) 的算法。
*/

public class SearchInsert {
    public static void main(String args[]){
        int[] nums={1,3,5,6};
        int target=5;
        SearchInsert obj=new SearchInsert();
        System.out.println(obj.searchInsert(nums,target));
    }

    public int searchInsert(int[] nums, int target) {
        int end=nums.length,start=0;
        while(start<end){
            int mid=(end+start)/2;
            if(target<=nums[mid]){
                end=mid;
            }
            else{
                start=mid+1;
            }
        }
        return start;
        
    }
    
}
