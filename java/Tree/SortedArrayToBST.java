package Tree;
import java.util.*;
/*有序数组转二叉搜索树 */
public class SortedArrayToBST {
    //  public TreeNode sortedArrayToBST(int[] nums) {
    //     if(nums.length==0){
    //         return null;
    //     }
    //     int mid=nums.length/2;
    //     TreeNode root=new TreeNode(nums[mid]);
    //     root.left=sortedArrayToBST( Arrays.copyOfRange(nums, 0,mid));
    //     root.right=sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
    //     return root;
        
    // }
    public TreeNode sortedArrayToBST(int[] nums) {
        // if(nums.length==0){
        //     return null;
        // }
       return patition(nums,0,nums.length);
        
    }

    public TreeNode patition(int []nums,int l,int r){
        if(l>=r){
            return null;
        }
        int mid=(l+r)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=patition(nums,l,mid);
        root.right=patition(nums,mid+1,r);
        return root;
    }
    public static void main(String[] args) {
        SortedArrayToBST obj = new SortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = obj.sortedArrayToBST(nums);
        System.out.println("Root of the BST: " + root.val);
        // You can add more code to print the tree or verify its structure
    }
}
