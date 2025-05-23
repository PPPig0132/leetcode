import ListNode.ListNode;

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode new_head=new ListNode(),end,pre;
        new_head.next=head;
        pre=new_head;end=head;
        while(end!=null && end.next!=null){
            if(end.val==end.next.val){
                int mark=end.val;
                while(end!=null && end.val==mark){
                    end=end.next;
                }
                pre.next=end;
                continue;
            }
            pre=end;
            end=end.next;
        }
        return  new_head.next;
    }
    public static void main(String[] args) {
        int values[] = {1, 1, 2, 3, 3};
        ListNode head = ListNode.generateLinkList(values);
        ListNode.printList(head);
        DeleteDuplicates dd = new DeleteDuplicates();
        ListNode result = dd.deleteDuplicates(head);
        ListNode.printList(result);
    }
}
