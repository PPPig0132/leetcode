package DoublePointer;

public class MaxArea {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1,ans=0;
        while(l<r){
            if(height[l]>=height[r]){
                ans=Math.max((r-l)*height[r],ans);
                r--;
            }
            else{
                ans=Math.max((r-1)*height[l],ans);
                l++;
            }
        }
       return ans;
    }
    public static void main(String[] args) {
        MaxArea maxArea=new MaxArea();
        int []height={1,1};
        System.out.println(maxArea.maxArea(height)); //49
    }
}
//     