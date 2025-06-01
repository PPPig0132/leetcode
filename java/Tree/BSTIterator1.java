package Tree;

import java.util.*;
class BSTIterator {
    public List<Integer> order=new ArrayList<>();
    public int pos;

    public BSTIterator(TreeNode root) {
        Deque<TreeNode> stk=new LinkedList<>();
        TreeNode cur=root;
       // stk.push(root);
        while(cur!=null || !stk.isEmpty()){
            while(cur!=null){
                stk.push(cur);
                cur=cur.left;
            }
            cur=stk.pop();
            order.add(cur.val);

            cur=cur.right;
        }
        pos=-1;
        
    }
    
    public int next() {
        return order.get(++pos);
        
    }
    
    public boolean hasNext() {
        if(pos<order.size()-1){
            return true;
        }
        return false;
        
    }
}
public class BSTIterator1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    
}
