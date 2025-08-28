package Tree;
// letcode  257
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//叶子节点 是指没有子节点的节点。


import java.util.*;

public class BinaryTerrPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res=new ArrayList<>();
        backtrack(root,res,new StringBuilder());
        return res;
        
    }

    public void backtrack(TreeNode root, List<String> ans, StringBuilder cur){
        String s=root.val+"";
        cur.append(s);
        if(root.left==null && root.right==null){
            ans.add(cur.toString());
            cur.setLength(cur.length() - s.length());
            return;
        }
       
        if(root.left!=null){
             cur.append("->");
            backtrack(root.left,ans,cur);
            cur.setLength(cur.length() -2);
        }
        if(root.right!=null){
             cur.append("->");
            backtrack(root.right,ans,cur);
            cur.setLength(cur.length() - 2);
        }
         cur.setLength(cur.length() - s.length());
        
    }
    public static void main(String[] args) {
        BinaryTerrPaths btp = new BinaryTerrPaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> paths = btp.binaryTreePaths(root);
        System.out.println("Binary Tree Paths: " + paths); // Output: ["1->2->5", "1->3"]
    }
}
