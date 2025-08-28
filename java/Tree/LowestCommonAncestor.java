package Tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(p==root || q==root){
            return root;
        }
        TreeNode l_lca=lowestCommonAncestor(root.left,p,q);
        TreeNode r_lca=lowestCommonAncestor(root.right,p,q);
        if(l_lca!=null && r_lca!=null){
            return root;
        }
        if(l_lca!=null){      
            return l_lca;
        }
        if( r_lca!=null){
            return r_lca;
        }
        return null;
        
    }
}
