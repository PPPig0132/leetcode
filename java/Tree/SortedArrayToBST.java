package Tree;
import java.util.*;
public class SortedArrayToBST {
    public static void main(String []args){

    }
     public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        int mid=nums.length/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST( Arrays.copyOfRange(nums, 0,mid));
        root.right=sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
        return root;
        
    }
}
