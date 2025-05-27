package Tree;
/* TreeNode with the **next** pointer */
public class Node {
    public int val;
    public Node next;
    public Node left;
    public Node right;

    public Node(){
        this.val = 0;
        this.next = null;
        this.left = null;
        this.right = null;
    }
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.left = null;
        this.right = null;
    }
    
}
