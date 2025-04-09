import java.util.Stack;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1); // 确保 nums1 是较短的数组
        }

        int left = 0;
        int right = m;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            int maxLeft1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRight1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int maxLeft2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRight2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or not valid.");
    }
    public boolean  isNumber(char c){
        return (c-'0')<9?true:false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2,5};

        double median = findMedianSortedArrays(nums1, nums2);
        Stack <int[]> stack = new Stack<>();

       int []x= new int []{1,2};
       stack.push(new int[]{1, 2});
       x[1]=3;
       stack.push(x);
       while(!stack.isEmpty()){
        int [] s1=stack.pop();
        for(int i=0;i<s1.length;i++){
            System.out.print(s1[i]+" ");
        }
       
       }

     
        FindMedianSortedArrays obj=new FindMedianSortedArrays();
        System.out.println(obj.isNumber(']')); // 输出 true
    }
}