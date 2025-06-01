package Tree;
/*给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 相邻节点的差值最小 */
import java.util.ArrayList;
import java.util.List;  
public class GetMinimumDifference {
    int ans=Integer.MAX_VALUE;
    List<Integer>nums=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        for(int i=1;i<nums.size();++i){
            ans=Math.min(ans,nums.get(i)-nums.get(i-1));
        }
        return ans;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return ;
        }
        dfs(root.left);
        nums.add(root.val);
        dfs(root.right);
       }
    public static void main(String[] args) {
        // 测试代码
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        GetMinimumDifference solution = new GetMinimumDifference();
        int result = solution.getMinimumDifference(root);
        System.out.println(result); // 输出: 1
    }
}
