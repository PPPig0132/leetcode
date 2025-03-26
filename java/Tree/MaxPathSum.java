package Tree;
import java.util.*;

public class MaxPathSum {
    int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
        
    }
    public int maxGain(TreeNode root){
        if (root==null){
            return 0;
        }
        int l=Math.max(maxGain(root.left),0);
        int r=Math.max(maxGain(root.right),0);
        int price=root.val+l+r;
        maxSum=Math.max(price,maxSum);
        return root.val+Math.max(l,r);
    }
}
