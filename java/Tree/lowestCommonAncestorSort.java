package Tree;

public class lowestCommonAncestorSort {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p || root==q) return root;
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        else if(root.val<p.val && root.val<q.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
    }
    public static void main(String[] args) {
        lowestCommonAncestorSort lca = new lowestCommonAncestorSort();
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.left.right; // Node with value 8
        TreeNode ancestor = lca.lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + ancestor.val); // Output: 6
    }
}
