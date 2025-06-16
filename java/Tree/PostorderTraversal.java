package Tree;

import java.util.*;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        
     List<Integer> ans= new ArrayList<>();
        dfs(root,ans);
        return ans;
    }
    public void dfs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        dfs(root.left,ans);
        dfs(root.right,ans);
        ans.add(root.val);
    }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PostorderTraversal solution = new PostorderTraversal();
        List<Integer> result = solution.postorderTraversal(root);

        // Print the result
        System.out.println("Postorder Traversal: " + result); // Output: Postorder Traversal: [4, 5, 2, 3, 1]
    }
}