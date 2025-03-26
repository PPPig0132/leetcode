package Tree;
import java.util.*;
import Tree.TreeNode;


public class InorderTraversa{
    public static void main(String []args){
        TreeNode root=new TreeNode(1);
        root.right=new TreeNode(2);
        root.right.left=new TreeNode(3);
        InorderTraversa it=new InorderTraversa();
        List<Integer> ans=it.inorderTraversal(root);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }

    }
     public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null){
            return new ArrayList<Integer>();
        }
        List<Integer> ans=new ArrayList<Integer>();
        List<Integer> l=new ArrayList<Integer>();
        List<Integer> r=new ArrayList<Integer>();

        if(root.left!=null){
            l=inorderTraversal(root.left);
        }
        while(l.size()>0){
            ans.add(l.remove(0));
        }
        ans.add(root.val);
        if(root.right!=null){
            r=inorderTraversal(root.right);
        }

       
        while(r.size()>0){
            ans.add(r.remove(0));
        }
        return ans;
    }
}