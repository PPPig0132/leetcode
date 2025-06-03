package BitOperation;
/*
给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问

idea:
使用位运算来统计每个位上1出现的次数。由于除了一个元素外，其他元素都出现了三次，因此每个位上1出现的次数模3的结果，就是那个只出现一次的元素在该位上的值。
*/

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int result = 0;
        // 遍历所有位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            // 统计第i位上1出现的次数
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            // 计算结果
            result |= (count % 3) << i;
        }
        return result;
    }
    public static void main(String[] args) {
        SingleNumberII solution = new SingleNumberII();
        int[] nums = {2, 2, 3, 2}; // 示例输入
        System.out.println(solution.singleNumber(nums)); // 输出: 3 (因为 3 只出现了一次)
    }
    
}
