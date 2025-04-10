package BinSearch;
import java.util.*;
/*给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。 
idea:只需遍历(m+n)/2+1个数，并且时刻记住最大的是b和不大于b的最大数a即可。待遍历完毕后，a就表示第(m+n)/2个数，b表示第(m+n)/2+1个数，如果（m+n）是奇数，那么b就是中位数，如果（m+n）是中位数，那么(a+b)/2就是中位数。

*/

public class FindMedianSortedArrays {
    public static void main(String args[]){
        int nums1[]={1,3};
        int nums2[]={2};
        int nums3[]={1,2};
        int nums4[]={3,4};
        FindMedianSortedArrays obj=new FindMedianSortedArrays();
        System.out.println(obj.findMedianSortedArrays(nums1,nums2));
        System.out.println(obj.findMedianSortedArrays(nums3,nums4));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m>n){
            return findMedianSortedArrays(nums2,nums1);//保证m始终是较小的数组长度
        }
        int left=0;
        int right=m;//在较短的数组上进行二分查找
            while(left<=right){
                int i=(left+right)/2;
                int j=(m+n+1)/2-i;//i+j=(m+n+1)/2 ,保证前半部分的数等于（一共偶数个）后半部分的数或者多一个（一共奇数个）

                int max_left1=(i==0)?Integer.MIN_VALUE:nums1[i-1];
                int min_right1=(i==m)?Integer.MAX_VALUE:nums1[i];
                int max_left2=(j==0)?Integer.MIN_VALUE:nums2[j-1];
                int min_right2=(j==n)?Integer.MAX_VALUE:nums2[j];
                
                if (max_left1 <= min_right2 && max_left2 <= min_right1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(max_left1, max_left2) + Math.min(min_right1, min_right2)) / 2.0;
                } else {
                    return Math.max(max_left1, max_left2);
                }
            } else if (max_left1 > min_right2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
            }
            return 0.0; // 如果输入数组不合法，返回0.0
            //throw new IllegalArgumentException("Input arrays are not sorted or not valid.");
    }
    
}
