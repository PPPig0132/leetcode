package Stack;
import java.util.*;
/*
 使用单调栈：
从左到右遍历柱子，使用单调栈存储柱子的索引。
当当前柱子的高度小于栈顶柱子的高度时，弹出栈顶柱子的索引，并计算以该柱子为高的矩形的面积。
重复上述过程，直到栈为空或当前柱子的高度大于等于栈顶柱子的高度。
计算矩形面积：
对于每个弹出的柱子，其左边界是栈中下一个柱子的索引(栈为空时左边界为起始点)，右边界是当前柱子的索引。
矩形的宽度是右边界减去左边界，高度是弹出的柱子的高度。
计算矩形的面积，并更新最大面积。
处理剩余柱子：
遍历结束后，栈中可能还剩下一些柱子。这些柱子的右边界是数组的长度。
依次弹出这些柱子，计算矩形的面积，并更新最大面积。
 */
public class ResLargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] stack = new int[n];
        int si = -1;
        int ans = 0;
        for(int i = 0; i < n; i++){
            while(si != -1 && heights[i] <= heights[stack[si]]){
                int j = stack[si--];
                int left = si == -1 ? -1 : stack[si];
                int right = i;
                ans = Math.max(ans, (right - left - 1) * heights[j]);
            }
            stack[++si] = i;
        }
        while(si != -1){
            int j = stack[si--];
            int left = si == -1 ? -1 : stack[si];
            int right = n;
            ans = Math.max(ans, (right - left - 1) * heights[j]);
        }
        return ans;
    }
    public static void main(String args[]){
        ResLargestRectangleArea obj=new ResLargestRectangleArea();
        int [] heights={2,1,5,6,2,3};
        System.out.println(obj.largestRectangleArea(heights));
    }
    
}
