package Array;
/*
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
*/

public class Trap {
    public int trap(int[] height) {
        int l=0,r=height.length-1,ans=0;
        int min=0;
        while(l<r){
            if(height[r]>=height[l]){//r小
                min=Math.max(height[l],min);
                ans+=min-height[l++];
            }
            else{
                min=Math.max(height[r],min);
                ans+=min-height[r--];
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = {4,2,0,3,2,5};
        System.out.println(trap.trap(height)); // Output: 6
    }
    
}
