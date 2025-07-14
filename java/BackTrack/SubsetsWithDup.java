package BackTrack;

import java.util.*;
/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
*/
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 对数组进行排序，方便去重
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        // 将当前子集添加到结果中
        result.add(new ArrayList<>(current));

        // 遍历数组，生成子集
        for (int i = start; i < nums.length; i++) {
            // 跳过重复的元素
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 将当前元素加入子集
            current.add(nums[i]);
            // 递归生成下一个子集
            backtrack(nums, i + 1, current, result);
            // 回溯，移除最后一个元素
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        int[] nums = {-1, 1, 2};
        List<List<Integer>> result = subsetsWithDup.subsetsWithDup(nums);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
