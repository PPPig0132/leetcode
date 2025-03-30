import java.util.HashMap;
public class Solution5 {
    public static void main(String[] args) {

        int [] array = {1,8,6,2,5,4,8,3,7};
  

        Solution5 solution = new Solution5();

        int answer = solution.maxArea(array);

    

        System.out.println("The sum of the array is: " +answer);

       
    }

    // public int maxArea(int[] height) {
    //     int len=1;
    //     int maxarea=0;
    //     int h;
    //     for(int i=0;i<height.length;i++){
    //         for(int j=0;(j+len)<height.length;j++){
    //             // h=min(height[j],height[j+len]);
    //             h=(height[j]>height[j+len])?height[j+len]:height[j];
    //             maxarea=(h*len>maxarea)?h*len:maxarea;
    
    //         }
    //         len++;
    //     }
    //     return maxarea;
            
    //     }
    public int maxArea(int[] height) {
        int pre=0;int end=height.length-1;
        int maxarea=0;
        int h;
        while(pre<end){
            h=(height[pre]>height[end])?height[end]:height[pre];
            maxarea=((end-pre)*h>maxarea)?(end-pre)*h:maxarea;

            if(height[pre]>height[end]){
                end--;
            }
            else{
                pre++;
            }

        }

        return maxarea;
            
        }


}