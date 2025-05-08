package Array;
/*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量

idea:
将值为val的值直接换到最后，不做处理，同时计数
*/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int end=n-1,start=0,count=0;
        while(start<=end){
            if(nums[start]==val){
                nums[start]=nums[end--];
                count++;
            }
            else{
                start++;
            }
        }
        return n-count;
        
    }
    public  static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] nums = {3};
        int val = 3;
        int newLength = solution.removeElement(nums, val);
        System.out.println("New length: " + newLength); // Output: 2
        // System.out.print("Modified array: ");
        // for (int i = 0; i < newLength; i++) {
        //     System.out.print(nums[i] + " ");
        // }
    }
    
}
