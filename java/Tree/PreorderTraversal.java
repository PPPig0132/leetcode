package Tree;
/*前序遍历*/
import java.util.*;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        dfs(root,ans);
        return ans;
    }
    public void dfs(TreeNode root, List<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
        dfs(root.left,ans);
        dfs(root.right,ans);
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PreorderTraversal solution = new PreorderTraversal();
        List<Integer> result = solution.preorderTraversal(root);

        // Print the result
        System.out.println("Preorder Traversal: " + result); // Output: Preorder Traversal: [1, 2, 4, 5, 3]
    }
}
