package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderOptim {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        levelOrder2(res, root, 0);
        return res;
    }
        public void levelOrder2(List<List<Integer>> res ,TreeNode node,int level) {
        if (node == null) {
            return;
        }
        if (res.size() <= level) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        res.get(level).add(node.val);
        if (node.left !=null) {
            levelOrder2(res, node.left, level+1);
        }
        if (node.right !=null) {
            levelOrder2(res, node.right, level+1);
        }

    }
    
}
