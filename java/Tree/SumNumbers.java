package Tree;
/*
给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：

例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。

叶节点 是指没有子节点的节点。
*/
import java.util.*;
public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        int ans=0;
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            int val=node.val;
            if(node.left!=null){
                node.left.val=val*10+ node.left.val;
                queue.offer(node.left);
            }

            if(node.right!=null){
                node.right.val=val*10+ node.right.val;
                queue.offer(node.right);
            }
            else{
                if(node.left==null){
                    ans+=node.val;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        int result = sumNumbers.sumNumbers(root);
        System.out.println("Sum of all numbers from root to leaf: " + result); // Output: 262
    }
}
