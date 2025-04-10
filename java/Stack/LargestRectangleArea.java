package Stack;
import java.util.*;
/*
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。

idea:
横着的最大的面积为当前数组中的最小值乘以数组长度

去除min  分别计剩下部分中面积最大值(当前部分的h*len)，直到去除所有的元素

对于每个数组，计算当前数组最小值乘以数组长度
将等于最小值的位置置零
对于每个子数组分别计算
直到去除所有的元素
[l,r,h] 将（l,r）中间根据当前的最小值进行分割
*/
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack= new Stack<int[]>();
        int h=Integer.MAX_VALUE;//min
        for(int i=0;i<heights.length;i++){
            if(heights[i]<=h){
                h=heights[i];
            }
        }
        stack.push(new int[]{0,heights.length,h});
        int ans=0;
        while(!stack.isEmpty()){
            int []top=stack.pop();
            h=top[2];
            int l=top[0],r=top[1];
            int len=r-l;
            int area=len*h;
            ans=Math.max(area,ans);
            //分区间 重新入栈
            h=Integer.MAX_VALUE;
            for(int i=l;i<=r;i++){
                if(i==r||heights[i]==top[2]){
                    
                    if(i!=l){
                        stack.push(new int[]{l,i,h});
                       
                        h=Integer.MAX_VALUE;
                     }
                     l=i+1;
                }
                else{
                    if(heights[i]<=h&&heights[i]!=top[2]){
                        h=heights[i];
                    }
                }
            }
           
            
            
        }
        return ans;
        
    }
    public static void main(String args[]){
        LargestRectangleArea obj=new LargestRectangleArea();
        int [] heights={2,1,5,6,2,3};
        int []h1={2,4};
        int ans=obj.largestRectangleArea(h1);
        System.out.println(ans);
    }
}
