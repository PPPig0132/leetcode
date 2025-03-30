import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
public class Solution11 {
    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        Solution11 obj = new Solution11();
        int[] result = obj.maxSlidingWindow(nums, k);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     List<Integer> ans=new ArrayList<>();
    //     int pre=0;
    //     int end=pre+k;
    //     int max=nums[0];
    //     for(int i=pre;i<end;i++){
    //         max=(nums[i]>max)?nums[i]:max;
    //     }
    //     ans.add(max);
    //     for(;pre<nums.length-k;){
    //         if(max==nums[pre]){
    //             pre++;
    //             end++;
    //             max=nums[pre];
    //             for(int i=pre;i<end;i++){
    //              max=(nums[i]>max)?nums[i]:max;
    //             }
    //             ans.add(max);
    //         }
    //         else{
    //             pre++;
    //             end++;
    //             max=(nums[end-1]>max)?nums[end-1]:max;
                
    //             ans.add(max);
    //         }
    
    
    //     }
    //     int[] ans1=new int[ans.size()];
    //     for(int i=0;i<ans.size();i++){
    //         ans1[i]=ans.get(i);
    //     }
    //     return ans1;
            
    //     }

   
}