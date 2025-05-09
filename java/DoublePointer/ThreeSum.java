package DoublePointer;
/*
请你返回所有和为 0 且不重复的三元组。
*/
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans =new ArrayList<List<Integer>>();
        int l=0,r=nums.length-1;
        quickSort(nums,l,r);
        for(int i=0;i<=r;++i){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int target=0-nums[i],start=i+1,end=r;
            while(start<end){
                int sum=nums[start]+nums[end];
                if(sum==target){
                    List<Integer>item=new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[start]);
                    item.add(nums[end]);
                    ans.add(item);
                    while(start<end&&nums[start]==nums[start+1]){
                        start++;
                    }
                    while(start<end&&nums[end]==nums[end-1]){
                        end--;
                    }
                    start++;
                    end--;
                }
                else if(sum<target){
                    start++;
                }
                else{
                    end--;
                }
            }

        }
        return ans;
        
    }
    public void quickSort(int []nums,int l,int r){
        if(l<r){
            int pivot=parition(nums,l,r);
            quickSort(nums,l,pivot-1);
            quickSort(nums,pivot+1,r);
        }
    }
    public int parition(int []nums, int l, int r){
        int pivot=nums[r];
        int index=l;
        for(int j=l;j<r;++j){
            if(nums[j]<pivot){
                swap(nums,index,j);
                index++;
            }
        }
        swap(nums, index, r);
        return index;
    }
    public void swap(int []nums, int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};//{-10,-5,-5,-4,-4,0,1,2,2,2,2,5,5}
        
        // ts.quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> result = ts.threeSum(nums);
        System.out.println(result);
    }
    
}
