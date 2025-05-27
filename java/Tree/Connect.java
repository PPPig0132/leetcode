package Tree;

/*填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。*/
import java.util.*;
public class Connect {

    public Node connect(Node root) {
        if(root == null)
            return null;
        Node dummy = new Node();
        dummy.next = root;
        while (dummy.next != null) {
            Node cur = dummy.next;
            dummy.next = null;
            Node tail = dummy;
            while (cur != null) {//为空的空指针不用修改，默认就是空指针
                if(cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if(cur.right != null){
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Connect connect = new Connect();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        
        connect.connect(root);
        
        // Print the next pointers
        System.out.println("Node 1 next: " + (root.next != null ? root.next.val : "null"));
        System.out.println("Node 2 next: " + (root.left.next != null ? root.left.next.val : "null"));
        System.out.println("Node 3 next: " + (root.right.next != null ? root.right.next.val : "null"));
    }
}
