package Tree;
import java.util.*;
/*给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）*/
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            int cur=que.size();
            for(int i=0;i<cur;++i){
                TreeNode node = que.poll();
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
                temp.add(node.val);
            }
            ans.add(0,new ArrayList<>(temp));
        }
        return ans;
        
    }
    public static void main(String[] args) {
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> result = levelOrderBottom.levelOrderBottom(root);
        // 输出结果
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
