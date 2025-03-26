package Tree;
import java.util.*;

public class RightSideView {
    public static void main(String args[]){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(4);
        RightSideView rsv=new RightSideView();
        List<Integer> ans=rsv.rightSideView(root);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }

    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> queue =new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int cur=queue.size();
            
            for(int i=0; i<cur; i++){
                TreeNode node=queue.poll();
                if(i==cur-1){
                    ans.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
        }
        return ans;
        
    }
    
    
}
