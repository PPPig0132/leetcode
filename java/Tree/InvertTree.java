package Tree;

public class InvertTree {
    public static void main(String []args){

    }
    public TreeNode invertTree(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode l=invertTree(root.left);
        TreeNode r=invertTree(root.right);
        root.left=r;
        root.right=l;
        return root;

    }
}
