package Tree;
import java.util.*;;
/*从前序与中序遍历序列构造二叉树 */
public class BuildTree {
    private Map<Integer,Integer> indexMap;

    public TreeNode build(int[] preorder, int[] inorder,int pre_left,int pre_right,int in_left, int in_right){
        if(pre_left>pre_right ){
            return null;
        }
        int pre_root=pre_left;
        int in_root=indexMap.get(preorder[pre_root]);
        TreeNode root=new TreeNode(preorder[pre_root]);
        
        int sub_l=in_root-in_left;

        root.left=build(preorder,inorder,pre_left+1,pre_left+sub_l,in_left,in_root-1);
        root.right=build(preorder,inorder,pre_left+sub_l+1,pre_right,in_root+1,in_right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        indexMap=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return build(preorder,inorder,0,n-1,0,n-1);
           

        
    }
    
}
