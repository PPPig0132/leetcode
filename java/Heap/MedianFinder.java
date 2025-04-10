package Heap;
/*
 基于优先队列实现最大堆和最小堆，分别存储大的一半和小的一半

如果最大堆为空或新元素小于最大堆的堆顶，则将新元素添加到最大堆。
否则，将新元素添加到最小堆。
保持两个堆的大小平衡，确保最大堆的大小等于最小堆的大小或比最小堆多一个元素。

如果两个堆的大小相等，中位数是两个堆顶的平均值。
如果最大堆的大小比最小堆多一个，中位数是最大堆的堆顶。
 
 */
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // 最大堆，存储较小的一半
    private PriorityQueue<Integer> minHeap; // 最小堆，存储较大的一半

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // 降序((a, b) -> b - a) ：b大于a就交换ab的位置 即降序
        minHeap = new PriorityQueue<>(); // 升序
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // 平衡两个堆的大小
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    
    }
}
