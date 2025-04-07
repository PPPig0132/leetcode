package BinSearch;
import java.util.*;
/*
给你一个满足下述两条属性的 m x n 整数矩阵：

每行中的整数从左到右按非严格递增顺序排列。
每行的第一个整数大于前一行的最后一个整数。
给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。

将二维数组展开为一维数组后进行二分查找，时间复杂度O(log(m*n))
*/

public class SearchMatrix {
    public static void main(String args[]){
        int[][] matrix={{1,1}};
        int matrix1[][]={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1=3;
        int target=2;
        SearchMatrix obj=new SearchMatrix();
        // System.out.println(obj.searchMatrix(matrix1,target1));
        System.out.println(obj.searchMatrix(matrix,target));
    }
    //  public boolean searchMatrix(int[][] matrix, int target) {
    //     if(matrix.length==0){
    //         return false;
    //     }
    //     int r=matrix.length,c=matrix[0].length;
    //     int start=0,end=r-1;
    //     //二分找到在第start行
    //     while(start<=end){
    //         int mid=start+(end-start)/2;
    //         if(target==matrix[mid][0]){
    //             return true;
    //         }
    //         else if(matrix[mid][0]<target){
               
    //             start=mid+1;
    //         }
    //         else{
    //             end=mid-1;
    //         }

    //     }
    //     System.out.println("start="+start);
    //     start--;
    //     int s=0,e=c-1;
    //     while(s<=e){
    //         int mid=s+(e-s)/2;
    //         if(matrix[start][mid]==target){
    //             return true;
    //         }
    //         else if(matrix[start][mid]<target){
               
    //             s=mid+1;
    //         }
    //         else{
    //             e=mid-1;
    //         }
    //     }

    //     return false;

        
    // }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n]; // 将一维索引映射回二维矩阵

            if (midValue == target) {
                return true; // 找到目标值
            } else if (midValue < target) {
                left = mid + 1; // 目标值在右侧
            } else {
                right = mid - 1; // 目标值在左侧
            }
        }

        return false; // 未找到目标值
    }
}
