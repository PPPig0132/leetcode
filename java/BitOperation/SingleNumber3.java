package BitOperation;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers to get a ^ b
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        // Step 2: Find the rightmost set bit in xor
        int mask = xor & (-xor);
        
        // Step 3: Divide numbers into two groups and XOR separately
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        
        return new int[]{a, b};
    }
    public static void main(String[] args) {
        SingleNumber3 sn3 = new SingleNumber3();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = sn3.singleNumber(nums);
        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }
}
