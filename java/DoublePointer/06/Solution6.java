import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Solution6 {
    public static void main(String[] args) {

        int [] array = {-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        int target = 9;

        Solution6 solution = new Solution6();
        List<List<Integer>> answer =solution.threeSum(array);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }


        // System.out.println("The sum of the array is: " +answer[0]+answer[1]);

       
    }

    public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans= new ArrayList<>(); 
    int a,b;
    for(int i=0;i<nums.length-2&&nums[i]<=0;i++){
        if(i>0&&nums[i]==nums[i-1]){
            continue;
        }
        a=nums[i];
        for(int j=i+1;j<nums.length;j++){
            if(nums[j]==nums[j-1]&&j>i+1){
                continue;
            }
            b=nums[j];
            if((a+b)<=0){
                for(int k=j+1;k<nums.length;k++){
                    if(a+b+nums[k]==0){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(a);
                        temp.add(b);
                        temp.add(nums[k]);
                        ans.add(temp);
                        break;

                    }
                }
                
            }
            else{
                break;
            }

        }
       
    }
    return ans;

        
    }

}