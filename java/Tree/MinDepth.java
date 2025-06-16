package Tree;

/*给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
*/

public class MinDepth {
     public int minDepth(TreeNode root) {
        if(root==null) return 0;
        
        return getDepth(root,1);
    }
    public int getDepth(TreeNode root,int dep){
        if(root.right==null&& root.left==null) return dep ;
        int l=Integer.MAX_VALUE,r=Integer.MAX_VALUE;
        
        if(root.left!=null){
             l=getDepth(root.left,dep+1);
        }
        if(root.right!=null){
             r=getDepth(root.right,dep+1);
       }
        
        return Math.min(l,r);

    }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        
        MinDepth solution = new MinDepth();
        int result = solution.minDepth(root);
        
        // Print the result
        System.out.println("Minimum Depth: " + result); // Output: Minimum Depth: 2
    }
}
