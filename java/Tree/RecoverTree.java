package Tree;
/*
给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 

idea:
引入辅助函数check，看左右节点是否有异常的点
与最近公共祖先（LCA）思路类似，先找到最近公共祖先，再定位异常点，再交换值
*/
public class RecoverTree {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // 中序遍历二叉搜索树
        inorderTraversal(root);

        // 交换两个错误节点的值
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;

        // 遍历左子树
        inorderTraversal(node.left);

        // 检查当前节点是否违反了BST的性质
        if (prev != null && prev.val >= node.val) {
            // 如果是第一次发现逆序对，记录第一个错误节点
            if (first == null) {
                first = prev;
            }
            // 记录第二个错误节点
            second = node;
        }

        // 更新前一个节点
        prev = node;

        // 遍历右子树
        inorderTraversal(node.right);
    }
    public static void main(String[] args) {
        RecoverTree rt = new RecoverTree();
        // 创建一个二叉搜索树
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(4);
        // root.right.left = new TreeNode(2); // 这里的2和3交换了位置

        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(2);

        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(1);
        // 恢复二叉搜索树
        rt.recoverTree(root);

        // 输出恢复后的树结构
        System.out.println("恢复后的树根节点值: " + root.val); // 应该是1
    }
}
