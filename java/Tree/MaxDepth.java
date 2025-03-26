package Tree;


public class MaxDepth {
    public static void main(String args[]){

    }
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int l=maxDepth(root.left);
        int r=maxDepth(root.right);

        int ans=l>r?l:r;
        return ans+1;
    }
    
}
