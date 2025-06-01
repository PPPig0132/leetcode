package Heap;
import java.util.*;
//通过小根堆来实现
public class FindKthLargest2 {
    public int findKthLargest(int[] nums, int k) {
            int heapSize = k;
            buildMaxHeap(nums, heapSize);
            for (int i = k; i < nums.length; ++i) {
                if(nums[i]>nums[0]){
                    swap(nums,0,i);
                    maxHeapify(nums,0,heapSize);
                }
            }
            return nums[0];
        }
    
        public void buildMaxHeap(int[] a, int heapSize) {
            for (int i = heapSize / 2 - 1; i >= 0; --i) {// i = heapSize / 2 - 1 i为最后一个根节点
                maxHeapify(a, i, heapSize);
            } 
        }
    
        public void maxHeapify(int[] a, int i, int heapSize) {
            int l = i * 2 + 1, r = i * 2 + 2, largest = i;
            if (l < heapSize && a[l] < a[largest]) {
                largest = l;
            } 
            if (r < heapSize && a[r] < a[largest]) {
                largest = r;
            }
            if (largest != i) {
                swap(a, i, largest);
                maxHeapify(a, largest, heapSize);
            }
        }
    
        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
    }
    public static void main(String args[]){
        int[] nums={3,2,1,5,6,4};
        int k=3;
        FindKthLargest obj=new FindKthLargest();
        FindKthLargest2 obj2=new FindKthLargest2();
        System.out.println(obj2.findKthLargest(nums,k));
        System.out.println(obj.findKthLargest(nums,k));
    }
}
