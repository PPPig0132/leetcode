package Tree;
/*
给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
*/
public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return countNodes(root.left)+countNodes(root.right)+1;
    }
 }
    
