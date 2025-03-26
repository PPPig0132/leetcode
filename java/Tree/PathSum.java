package Tree;
import java.util.*;

public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        Map <Long,Integer> prefix=new HashMap<Long,Integer>();
        prefix.put(0L,1);
        return dfs(root,prefix,0L,targetSum);

    }
    public int dfs(TreeNode root,Map<Long,Integer> prefix,Long cur,Integer targetSum){
        if(root==null){
            return 0;
        }
        int ret=0;
        cur+=root.val;
        ret=prefix.getOrDefault(cur-targetSum,0);
        prefix.put(cur,prefix.getOrDefault(cur,0)+1);
        ret+=dfs(root.left,prefix,cur,targetSum);
        ret+=dfs(root.right,prefix,cur,targetSum);
        prefix.put(cur,prefix.getOrDefault(cur,0)-1);

        return ret;
    }
    
}
