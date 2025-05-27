package Tree;
import Tree.TreeNode;
public class BuildTree_In_post {
    private int pos, in;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.pos=inorder.length-1;
        this.in=inorder.length-1;
        TreeNode root=dfs(inorder,postorder,Integer.MAX_VALUE);
        return root;
    }

    public TreeNode dfs(int []inorder,int []postorder, int stop){
        if(pos==-1){
            return null;
        }
        if(inorder[in]==stop){
            in--;
            return null;
        }
        int val=postorder[pos--];
        TreeNode Node = new TreeNode(val);
        Node.right=dfs(inorder,postorder,val);
        Node.left=dfs(inorder,postorder,stop);
        return Node;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        BuildTree_In_post buildTree = new BuildTree_In_post();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = buildTree.buildTree(inorder, postorder);
        buildTree.preOrder(root); // Print the postorder traversal of the constructed tree
        // You can add code here to print or verify the tree structure
    }
}
