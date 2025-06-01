package Heap;

/*
每次从堆中取出和最小的数对，加入结果列表。
如果该数对的第二个元素来自 nums2 的第 j 个位置，且 j+1<nums2.length，则将 (nums1[i], nums2[j+1]) 加入堆中。
*/

import java.util.*;

public class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        // 定义最小堆，按数对的和排序
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        // 初始化堆，将 nums1 的每个元素与 nums2 的第一个元素组成数对
        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0}); // 数对格式：{nums1[i], nums2[j], j}
        }

        // 迭代 k 次或堆为空
        while (k > 0 && !minHeap.isEmpty()) {
            int[] currentPair = minHeap.poll();
            int u = currentPair[0];
            int v = currentPair[1];
            int j = currentPair[2]; // 当前数对在 nums2 中的索引

            // 将当前数对加入结果列表
            List<Integer> pair = new ArrayList<>();
            pair.add(u);
            pair.add(v);
            result.add(pair);

            // 如果当前数对的第二个元素还有后续元素，将下一个数对加入堆
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{u, nums2[j + 1], j + 1});
            }

            k--;
        }

        return result;
    }
    
}
