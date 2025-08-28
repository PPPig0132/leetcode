import ListNode.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head.next==null) return;
        ListNode pre=head,end=head;
        while(end.next!=null){
            pre=pre.next;
            end=end.next;
            if(end.next!=null){
                end=end.next;
            }
        }
        reverse(pre);
        insert(head,pre);

    }

    public void reverse(ListNode head){
        ListNode temp=head.next;
        head.next=null;
        while(temp!=null){
            ListNode node=temp;
            temp=temp.next;
            node.next=head.next;
            head.next=node;
        }
    }
    public void insert(ListNode head1,ListNode head2){
        ListNode temp=head2.next;
        head2.next=null;
        head2=head1;
        while(temp!=null){
            ListNode node=temp;
            temp=temp.next;
            node.next=head2.next;
            head2.next=node;
            head2=head2.next.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        

        ReorderList reorder = new ReorderList();
        reorder.reorderList(head);

        // Print reordered list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
