package Tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder2 {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
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
           ans.get(deepth).add(root.val);
        }
        deepth++;
        dfs(root.left,deepth);
        dfs(root.right,deepth);
    }
}
