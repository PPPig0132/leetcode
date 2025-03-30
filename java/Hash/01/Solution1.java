
public class Solution1 {
    public static void main(String[] args) {

        int [] array = {2, 7, 11, 15};
        int target = 9;

        Solution1 solution = new Solution1();

        int []answer =solution.twoSum(array, target);

        System.out.println("The sum of the array is: " +answer[0]+answer[1]);

       
    }

    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }

        return ans;
        
    }

}