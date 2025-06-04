package BitOperation;
/*
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
通过异或(^)运算来求解
*/
import java.util.*;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
        
    }
    public static void main(String[] args) {
        SingleNumber solution = new SingleNumber();
        int[] nums = {4,1,2,1,2};
        System.out.println(solution.singleNumber(nums)); // Output: 4 (The single number is 4.)
    }
}
