package Tree;
import java.util.*;

/*二叉树展开为链表 */
public class Flatten {

    public void flatten(TreeNode root) {
        if (root==null){
            return;
        }
        Deque<TreeNode> stk=new LinkedList<TreeNode>();
        stk.push(root);
        TreeNode prev=null;
        while(!stk.isEmpty()){
        TreeNode cur=stk.pop();
        if(prev!=null){
            prev.left=null;
            prev.right=cur;
        }
        TreeNode left=cur.left,right=cur.right;
        if(right!=null){
            stk.push(right);
        }
        if(left!=null){
            stk.push(left);
        }

        prev=cur;


        }
        
    }
    
}
