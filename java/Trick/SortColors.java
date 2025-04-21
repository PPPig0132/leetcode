package Trick;

/*
给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
idea：
使用前后指针，l指针指向最后一个0，r指针指向第一个2，将0和2排好，1也就排好了
如果前指针指到2则和r交换，如果后指针指到0，则与前面的交换
*/

public class SortColors {
    public void sortColors(int[] nums) {
        int l=-1,p=0,r=nums.length-1;
        while(p<=r){
            if(nums[p]==0){
                swap (nums,p,++l);
                p=l+1;
            }
            else if(nums[p]==2){
                swap (nums,p,r);
                r--;
                // p++;
            }
           
            else {
                ++p;
            }
          
        }
        
        
    }
    public void swap(int []nums, int i, int j) {//异或操作无法解决两个相同的数的交换问题
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        SortColors solution = new SortColors();
        int[] nums = {2,1};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
