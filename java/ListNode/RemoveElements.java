import ListNode.ListNode;
/*给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。*/

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return head;
        ListNode new_head =new ListNode();
        new_head.next=head;
        ListNode pre=new_head,end=head;
        while(end!=null){
            while(end!=null&&end.val==val){
                end=end.next;
            }
            pre.next=end;
            if(end==null) return new_head.next;
            
            end=end.next;
            pre=pre.next;
        }
        return new_head.next;
        
    }
    public static void main(String[] args) {
        RemoveElements re = new RemoveElements();
        ListNode head = new ListNode(7);
        head.next = new ListNode(7);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode result = re.removeElements(head, 7);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
