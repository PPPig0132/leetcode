package BinSearch;
/*给你 旋转后 的数组 nums 和一个整数 target ，
请你编写一个函数来判断给定的目标值是否存在于数组中。
如果 nums 中存在这个目标值 target ，
则返回 true ，否则返回 false 。*/
public class SearchRotateArray {
    
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int l=0,r=n-1;
        return check(nums,l,r,target);
    }
    public boolean check(int []nums,int l,int r,int target){
        if(l>=r) return nums[l]==target; // 最后检查l位置的元素是否等于target
        int m=(l+r)/2;
        if(nums[m]==target) return true;

        if(nums[m]<target){
            if(nums[l]<nums[r])return check(nums,m+1,r,target);
            else{
                return check(nums,l,m-1,target) || check(nums,m+1,r,target);
            }
        }
        else{
             if(nums[l]<nums[r])return check(nums,l,m-1,target);
            else{
                return check(nums,l,m-1,target) || check(nums,m+1,r,target);
            }
        }

    }
    public static void main(String[] args) {
        SearchRotateArray sra = new SearchRotateArray();
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}; // 示例输入
        int target = 3; // 示例目标值
        boolean result = sra.search(nums, target);
        System.out.println(result); // 输出结果
    }
}
