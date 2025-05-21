package Ranges;

import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String>ans=new ArrayList<String>();
        if (nums.length==0){
            return ans;
        }
        else if (nums.length==1){
            ans.add(""+nums[0]);
            return ans;
        }
        int start =0;
        int end;
        for(int i=1;i<nums.length;++i){
            if(nums[i]-1!=nums[i-1]){
                StringBuilder sb = new StringBuilder();
                end=i-1;
                if(start==end){
                    sb.append(nums[start]);
                    ans.add(sb.toString());
                }
                else{
                    sb.append(nums[start]);
                    sb.append("->");
                    sb.append(nums[end]);
                    ans.add(sb.toString());
                }
                start=i;
            }
        }
        end=nums.length-1;
        StringBuilder sb = new StringBuilder();
        if(start==end){
            sb.append(nums[start]);
            ans.add(sb.toString());
        }
        else{
            sb.append(nums[start]);
            sb.append("->");
            sb.append(nums[end]);
            ans.add(sb.toString());
        }

        
        return ans;
    }
    public static void main(String[] args) {
        SummaryRanges solution = new SummaryRanges();
        int[] nums = {1,2};
        List<String> result = solution.summaryRanges(nums);
        System.out.println(result); // Output: ["0","2->4","6","8->9"]
    }
}
