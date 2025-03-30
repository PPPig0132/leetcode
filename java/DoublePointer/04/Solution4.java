
public class Solution4 {
    public static void main(String[] args) {

        int [] array = {0,1,0,3,12};
        int target = 9;

        Solution4 solution = new Solution4();

      
        solution.moveZeroes(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        // System.out.println("The sum of the array is: " +answer[0]+answer[1]);

       
    }

    public void moveZeroes(int[] nums) {
        int count_zero=0;
       // int pre=0;//用于记录前一个
        //int end=nums.length;//尾指针
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count_zero++;//计数器+1
            }
            else{
                int temp;//用于交换位置的中间变量
                temp=nums[i-count_zero];
                nums[i-count_zero]=nums[i];
                nums[i]=temp;
    
            }
        }
            
        }

}