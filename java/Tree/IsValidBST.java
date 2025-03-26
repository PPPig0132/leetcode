package Tree;

public class IsValidBST {
    public static void main(String args[]){

    }
    public boolean isValidBST(TreeNode root) {
        
        return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);

    }

    public boolean helper(TreeNode root,long maxValue,long minValue){//判断上下界
            if (root==null){
                return true;
            }
            if(root.val>maxValue || root.val<minValue){
                return false;
            }
            return helper(root.left,root.val,minValue) && helper(root.right,maxValue,root.val);

    }

}
