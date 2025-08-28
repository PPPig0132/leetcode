package BackTrack;
import Tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
/*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点。
*/

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        backtrack(root,targetSum,ans,new ArrayList<>(),0);
        return ans;
    }
    public void backtrack(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> temp,int sum){
        sum+=root.val;
        temp.add(root.val);
       
        //if(sum>=targetSum) //-1000<code.val<1000
        if(root.left!=null){
            backtrack(root.left,targetSum,ans,temp,sum);
        }
        if(root.right!=null){
            backtrack(root.right,targetSum,ans,temp,sum);
        }
        
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                ans.add(new ArrayList<>(temp));
            }
            sum-=root.val;
            temp.remove(temp.size()-1);
            return;
        }
        sum-=root.val;
        temp.remove(temp.size()-1);
    }
    public static void main(String[] args) {
        PathSum solution = new PathSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(5);

        int targetSum = 22;
        List<List<Integer>> result = solution.pathSum(root, targetSum);
        System.out.println(result); // 输出所有路径
    }
}
