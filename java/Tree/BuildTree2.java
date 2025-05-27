package Tree;
/*从前序与中序遍历序列构造二叉树 */
public class BuildTree2 {
    private int pre = 0, in = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }
    private TreeNode dfs(int[] preorder, int[] inorder, int stop){
        if(pre == preorder.length) return null;
        if(inorder[in] == stop){//判断左边边，in的初始值为0，中序遍历最左边即为最左边的节点
            in++;
            return null;
        }
        int val = preorder[pre++];
        TreeNode node = new TreeNode(val);
        node.left = dfs(preorder, inorder, val);
        node.right = dfs(preorder, inorder, stop);
        return node;
    }
    
}
