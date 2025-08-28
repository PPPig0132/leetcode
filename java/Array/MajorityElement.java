package Array;

import java.util.*;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        //if(nums.length<3) return new ArrayList<>(nums);
        int num1=0,num2=0,cn1=0,cn2=0;
        for(int i=0;i<nums.length;++i){
            if(cn1>0 && nums[i]==num1){
                cn1++;
            }
            else if(cn2>0 && nums[i]==num2){
                cn2++;
            }
            else  if(cn1==0){
                num1=nums[i];
                cn1++;
            }
            else if(cn2==0){
                num2=nums[i];
                cn2++;
            }
            else{
                cn1--;
                cn2--;
            }
        }
        cn1=cn2=0;
        int threshold=nums.length/3;
        for(int num:nums){
            if(num==num1) cn1++;
            else if(num==num2 ) cn2++;
        }
        List<Integer> ans=new ArrayList<>();
        if(cn1>threshold) ans.add(num1);
        if(cn2>threshold) ans.add(num2);
        return ans;
    }
    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {2,1,1,3,1,4,5,6};
        List<Integer> result = me.majorityElement(nums);
        System.out.println(result); // Output: [3]
    }
}
