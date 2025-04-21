package Trick;

/*
给你一个整数数组 nums ，找出 nums 的下一个排列。

idea:
1）从排列的右端开始，找出第一个比右边数字小的数字的序号j（j从左端开始计算），即 j=max{i|pi<pi+1}
2）在pj的右边的数字中，找出所有比pj大的数中最小的数字pk，即 k=max{i|pi>pj}（右边的数从右至左是递增的，因此k是所有大于pj的数字中序号最大者）
3）对换pj，pk
4）再将pj+1......pk-1pkpk+1......pn倒转得到排列p'=p1p2.....pj-1pjpn.....pk+1pkpk-1.....pj+1，这就是排列p的下一个排列。
*/

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int j=0,k=0,flag=0;
        for(int i=n-1;i>=1;--i){
            if(nums[i]>nums[i-1]){
                j=i-1;
                flag=1;
                break;
            }
        }
        if(flag==0){
            int l=0,r=n-1;
            while(l<r){
                int temp=nums[r];
                nums[r]=nums[l];
                nums[l]=temp;
                l++;
                r--;
            }
        }
        else{
            int r=n-1;
            while(r>j){
                if(nums[r]>nums[j]){
                    k=r;
                    break;
                }
                r--;
            }
            int temp=nums[k];
            nums[k]=nums[j];
            nums[j]=temp;
            int l=j+1;r=n-1;
             while(l<r){
                temp=nums[r];
                nums[r]=nums[l];
                nums[l]=temp;
                l++;
                r--;
            }

        }
        
    }
    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = {3,2,1};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    
}
