package Tree;
import java.util.*;

/*二叉树展开为链表 ，展开后与先序遍历顺序相同*/
public class Flatten2 {
    private TreeNode end;

    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        this.end=root;
        if(root.left==null){
            flatten(root.right);
        }
        else{
                TreeNode r=root.right;
                root.right=root.left;
                root.left=null;
                flatten(root.right);
                end.right=r;
                flatten(r);
        }
    }
    public static void main(String[] args) {
        Flatten2 flatten2 = new Flatten2();
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        flatten2.flatten(root);

        // Print the flattened tree
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
    
}
