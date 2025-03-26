package Tree;
/* 
如果 node 的左子树的结点数 left 小于 k−1，则第 k 小的元素一定在 node 的右子树中，令 node 等于其的右子结点，k 等于 k−left−1，并继续搜索；
如果 node 的左子树的结点数 left 等于 k−1，则第 k 小的元素即为 node ，结束搜索并返回 node 即可；
如果 node 的左子树的结点数 left 大于 k−1，则第 k 小的元素一定在 node 的左子树中，令 node 等于其左子结点，并继续搜索。

*/
import java.util.*;

public class KthSmallest {

    public static void main(String args[]){

    }

    public int kthSmallest(TreeNode root, int k) {
        MyBst bst=new MyBst(root);
        return bst.kthSamllest(root,k);
        
    }

    
}

class MyBst{
    TreeNode root;
    Map<TreeNode,Integer> nodeNum;

    public MyBst(TreeNode root){
        this.root=root;
        this.nodeNum=new HashMap<TreeNode,Integer>();
        countNodeNum(root);

    }

    public int kthSamllest(TreeNode root,int k){
        TreeNode node=root;
        while(node!=null){
            int l=getNodeNum(node.left);
            if(l<k-1){
                node=node.right;
                k-=l+1;
            }
            else if (l==k-1){
                break;
            }
            else{
                node=node.left;
            }

        }
        return node.val;
    }

    private int countNodeNum(TreeNode root){
        if(root==null){
            return 0;
        }
        nodeNum.put(root,1+countNodeNum(root.left)+countNodeNum(root.right));
        return nodeNum.get(root);

    }
    private int getNodeNum(TreeNode node){
        return nodeNum.getOrDefault(node,0);
    }
}
