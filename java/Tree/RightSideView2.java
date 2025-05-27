package Tree;
import java.util.*;
/*二叉树的右视图*/
public class RightSideView2 {
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return  res;
        
        
    }
    public void dfs(TreeNode root,int depth){
        if(root==null) return ;

        if(depth==res.size()){
               res.add(root.val);
        }
        depth++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
    public static void main(String[] args) {
        // 测试代码
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        RightSideView2 solution = new RightSideView2();
        List<Integer> result = solution.rightSideView(root);
        System.out.println(result); // 输出: [1, 3, 4]
    }
    
}
