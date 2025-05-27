package Tree;
/*z型层次遍历*/
import java.util.*;

public class ZigzagLevelOrder {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        dfs(root,0);
        return ans;
    }
    public void dfs(TreeNode root, int deepth){
        if(root==null){
            return;
        }
        if(deepth==ans.size()){
            ans.add(new ArrayList<>());
            ans.get(deepth).add(root.val);
        }
        else{
            if(deepth % 2 == 0) {
                ans.get(deepth).add(root.val); // 偶数层从左到右
            } else {
                ans.get(deepth).add(0, root.val); // 奇数层从右到左
            }
        }
        deepth++;
        dfs(root.left,deepth);
        dfs(root.right,deepth);
       
        
        
    }
    public static void main(String[] args) {
        // 测试代码
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        ZigzagLevelOrder solution = new ZigzagLevelOrder();
        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println(result); // 输出: [[1], [3, 2], [5, 4]]
    }
    
}
