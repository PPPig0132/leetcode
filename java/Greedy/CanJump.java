package Greedy;
import java.util.*;
/*
给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
已知：如果能到最后一个下标，那么一定能到倒数第二个下标（i+nums[i]>=nums.length-1则i+nums[i]>nums.length-1-x,x>0）
从最后一个下标往前推，找到第一个从当前位置起跳能到最后一个下标的点，再判断从前面的点能否跳到当前点。
*/
public class CanJump {
     public boolean canJump(int[] nums) {
        int terminal=nums.length-1;
        for(int i=nums.length-1;i>=0;--i){
            if(i+nums[i]>=terminal){
                terminal=i;
            }
        }
        return terminal==0?true:false;
    }
    public static void main(String args[]){
        //int nums[]={2,3,1,1,4};
        int nums[]={3,2,1,0,4};
        CanJump obj=new CanJump();
        System.out.println(obj.canJump(nums));
    }
    
}
