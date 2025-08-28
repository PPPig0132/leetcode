package Tree;

import ListNode.ListNode;
/*由有序链表构建平衡二叉树*/

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head,null);
    }
    public TreeNode buildBST(ListNode head, ListNode end){
        if(head==end) return null;
        ListNode slow=head,fast=head;
        while(fast.next!=end){
            slow=slow.next;
            fast=fast.next;
            if(fast.next!=end) {
                fast=fast.next;
            }
        }
        TreeNode node=new TreeNode(slow.val);
        node.left=buildBST(head,slow);
        node.right=buildBST(slow.next,end);
        return node;
    }
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        SortedListToBST solution = new SortedListToBST();
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        
        TreeNode root = solution.sortedListToBST(head);
        solution.preOrder(root);  // 输出前序遍历结果
    }
}
