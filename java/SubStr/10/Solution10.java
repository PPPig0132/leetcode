
public class Solution10 {
    public static void main(String[] args) {

        int [] array = {1,1,-1,-1};
        int target = 0;

        Solution10 solution = new Solution10();
        int answer = solution.subarraySum(array, target);

        System.out.println("The sum of the array is: "+answer);

       
    }
    public int subarraySum(int[] nums, int k) {
        int pre=0;
        int end=0;
        int sum=k;
        int count=0;
        for(;pre<nums.length&&end<nums.length;){
            sum-=nums[end];
            if(sum==0){//找到和为k的字串
             count++;
             end++;
             sum+=nums[pre]; //移除第一个元素
             pre++;
            }
            else if(sum>0){
                end++;
            }
            else{//sum<0,即和大于k了，移除前面的元素
                sum+=nums[pre]; //移除第一个元素
                pre++;
                sum+=nums[end];//放不下，先把当前元素挪出去
            }
    
        }
        return count;
            
        }

   
}