package Tree;
/*判断该树中是否存在**根节点**到**叶子节点**的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。*/
public class HasPathSum {
    // private int remains=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        // this.remains=targetSum;
        if(root.left==null && root.right==null && root.val==targetSum){
            return true;
        }
        boolean l = hasPathSum(root.left, targetSum-root.val);
        boolean r = hasPathSum(root.right, targetSum-root.val);

        return l ||  r;
    }
    public static void main(String[] args) {
        HasPathSum hasPathSum = new HasPathSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum =22;
        boolean result = hasPathSum.hasPathSum(root, targetSum);
        System.out.println("Has path sum: " + result); // Output: true
    }
    
}
