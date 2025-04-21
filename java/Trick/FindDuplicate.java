package Trick;
/*
给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
idea:
使用快慢指针判圈法
我们可以将数组中的每个数字视为一个链表的节点，其中每个节点的值指向下一个节点的索引。例如，如果 nums[0] = 2，则从索引 0 指向索引 2。由于数组中存在重复的数字，这个链表中必然存在环

将 slow 指针重新指向数组的起始位置。
保持 fast 指针在相遇位置，然后让 slow 和 fast 每次都移动一步，直到它们再次相遇。相遇点即为环的入口，也就是重复的数字。
*/
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        // 初始化两个指针
        int slow = nums[0];
        int fast = nums[0];

        // 检测环
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 找到环的入口
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args) {
        FindDuplicate solution = new FindDuplicate();
        int[] nums = {2,3,4,3,3};
        System.out.println(solution.findDuplicate(nums)); // Output: 2 (The duplicate number is 2.)
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
    
}
