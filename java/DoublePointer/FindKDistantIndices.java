package DoublePointer;

import java.util.*;
/*返回与数组中值为key的元素距离在k以内的下标，按大小顺序*/
public class FindKDistantIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n=nums.length;
        List<Integer>ans =new ArrayList<>();
        boolean mark[]=new boolean[n];
        int l=0;
        for(int i=0;i<n;++i){
            if(nums[i]==key){
                int start=Math.max(l,i);
                while(start<n && start<=i+k){
                    mark[start]=true;
                    start++;
                }
                l=start;
            }
        }

        for(int i=n-1;i>=0;--i){
            if(nums[i]==key){
                int start=Math.min(l,i);
                while(start>=0 && start>=i-k){
                    mark[start]=true;
                    start--;
                }
                l=start;
            }
        }
        for(int i=0;i<n;++i){
            if(mark[i]) ans.add(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        FindKDistantIndices finder = new FindKDistantIndices();
        int[] nums = {3,4,9,1,3,9,5};
        int key = 9;
        int k = 1;
        List<Integer> result = finder.findKDistantIndices(nums, key, k);
        System.out.println("Indices with value " + key + " within distance " + k + ": " + result); // 输出: [2, 1, 3]
    }
}
