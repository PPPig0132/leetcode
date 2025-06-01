package Tree;
import Tree.TreeNode;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null ){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.right,q.right) && isSameTree(q.left,p.left);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(2);

        IsSameTree isSameTree = new IsSameTree();
        System.out.println(isSameTree.isSameTree(p, q)); // Output: true
    }
}
