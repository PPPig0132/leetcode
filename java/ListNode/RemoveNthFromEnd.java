import ListNode.ListNode;
public class RemoveNthFromEnd {
    public static void main(String [] args){

    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        if(head==null){
            return null;
        }
        ListNode end=head,pre=head;
        while(n>0){//
            end=end.next;
            n--;
        }
        if(end==null){
            head=head.next;
            return head;
        }
        while(end.next!=null){
            pre=pre.next;
            end=end.next;
        }
        pre.next=pre.next.next;
        return head;
    }
    
}