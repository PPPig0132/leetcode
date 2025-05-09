package DoublePointer;
/*
从有序数组中返回和为target的两个元素的下标（从1开始）
仅有一个有效答案
*/
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1,sum;
        int []ans=new int[2];
        while(l<r){
            sum=numbers[l]+numbers[r];
            if(sum==target){
                ans[0]=l+1;
                ans[1]=r+1;
                return ans;
            }
            else if(sum>target){
                r--;
            }
            else{
                l++;
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        TwoSum twoSum=new TwoSum();
        int []numbers={2,7,11,15};
        int target=9;
        int []ans=twoSum.twoSum(numbers,target);
        for(int i:ans){
            System.out.print(i+" ");
        }
        //System.out.println(ans[0]+" "+ans[1]);
    }
    
}
