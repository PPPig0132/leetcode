
public class Solution7 {
    public static void main(String[] args) {

        int [] array = {4,2,0,3,2,5};
        int [] array1 = {0,2,0};
        int [] array2 = {0,1,0,2,1,0,1,3,2,1,2,1};

        Solution7 solution = new Solution7();

        int answer =solution.trap(array1);

        System.out.println("The sum of the array is: " +answer);

       
    }

    // public int trap(int[] height) {
    //     int sum_rain=0;
    //     int pre=0;
    //     int end;
       
    //     for(;pre<height.length-1;){
    //         end=pre+1;
    //         int sum1=0;
    //         if(height[pre]==0){
    //             pre++;
    //             continue;
    //         }
    //         while(end<height.length&&height[end-1]>height[end]){
    //         sum1+=height[end];
    //         end++;
    //         }
    //         if(end==height.length){
    //             pre++;
    //         }
    //         else{//找到符合条件的右端
               
    //         while(end<height.length&&height[end-1]<height[end]){
    //             sum1+=height[end];
    //             end++;
    //         }
    //         end--;
    //         // if(end==height.length){
    //         //     end--;
    //         // }
            
    //         int h= (height[pre]>height[end])?height[end]:height[pre];
    //         sum_rain+=((end-pre-1)*h-sum1+height[end]);
    //         System.out.println("left: "+pre+" right: "+end+" sum "+((end-pre-1)*h-sum1));
    //         pre=end;
    //         }
            
    //     }
    //     return sum_rain;
            
    //     }
    public int trap(int[] height) {
        int sum_rain=0;
        int pre=0;
        int end;
       
        for(;pre<height.length-1;){
            if(height[pre]==0){
                pre++;
                continue;
            }
            end=pre+1;
            int sum1=0;
            int sum2=0;//用于没有V1.0找到的的情况
            int max=0; int max_index=end;//记录除了左端外的最大值
            while(end<height.length&&height[pre]>height[end]){
            sum1+=height[end];
            
            if(height[end]>max){
                max=height[end];
                max_index=end;
                }   
            end++;
            }
            if(end==height.length){//没有找到左低右高的最大容器
                for(int j=pre+1;j<max_index;j++){
                    sum2+=height[j];
                }
                System.out.println("pre: "+pre+"  maxindex: "+max_index);
                int h= height[max_index];
                sum_rain+=((max_index-pre-1)*h-sum2);
                pre=max_index;
            }
            else{//找到符合条件的右端
            int h= (height[pre]>height[end])?height[end]:height[pre];
            sum_rain+=((end-pre-1)*h-sum1);
            pre=end;
            }
            
        }
        return sum_rain;
            
        }

}