package Array;
/*
 *给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 idea:
 从后往前比较可以避免插入时的数组元素后移
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int i=m-1,j=n-1,x=m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[x--]=nums1[i--];
            }
            else{
                nums1[x--]=nums2[j--];
            }
        }
        //判断哪条还剩
        if(j>=0){
            while(j>=0){
                nums1[x--]=nums2[j--];
            }
        }
        else if(i>=0){
             while(i>=0){
                nums1[x--]=nums1[i--];
            }
        }
        
    }
    public static void main(String[] args) {
        Merge solution = new Merge();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        solution.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
    
}
