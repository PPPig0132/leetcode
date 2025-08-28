import ListNode.ListNode;
/*
 * 在不知道前驱节点的前提下删除当前节点
 * idea:讲当前节点的值替换为下一个节点的值，然后删除下一个节点
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
    
}
